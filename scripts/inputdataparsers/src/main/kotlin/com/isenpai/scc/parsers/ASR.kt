package com.isenpai.scc.parsers

import com.isenpai.scc.dao.acas.ACASProdRef
import com.isenpai.scc.dao.acas.ASRBenchmarkId
import com.isenpai.scc.dao.acas.ASRMessage
import com.isenpai.scc.dao.acas.ASRRuleResult
import com.isenpai.scc.xml.findElementByTagName
import com.isenpai.scc.xml.forEach
import org.w3c.dom.Document
import org.w3c.dom.Element

fun print(msg: ASRMessage) {
    println("<ASRMessage>")
    println("\t<ProdRef>")
    println("\t\tTopic         = ${msg.prodRef.topic}")
    println("\t\tTopic Dialect = ${msg.prodRef.topicDialect}")
    println("\t\tAddress       = ${msg.prodRef.address}")
    println("\t\t<Meta>")
    println("\t\t\tMessage ID = ${msg.prodRef.meta.messageId}")
    println("\t\t\tTag Name   = ${msg.prodRef.meta.tagName}")
    println("\t\t\tTag Val    = ${msg.prodRef.meta.tagValue}")
    println("\t<ResultPack>")
    println("\t\tCNDC     = ${msg.resultPack.cndc}")
    println("\t\tSumm Res = ${msg.resultPack.summRes}")
    println("\t\t<Benchmark>")
    println("\t\t\t<Benchmark ID>")
    println("\t\t\t\tResource  = ${msg.resultPack.benchmark.benchmarkId.resource}")
    println("\t\t\t\tRecord ID = ${msg.resultPack.benchmark.benchmarkId.recordIdentifier}")
    println("\t\t\t<Rule Results>")
    msg.resultPack.benchmark.ruleResults.forEach { rr ->
        println("\t\t\t\tRuleID = ${rr.ruleId}, ident = ${rr.ident.data}, result = ${rr.ruleComplianceItem.ruleResult}, count = ${rr.ruleComplianceItem.result.count}")
    }
    println("\t\t<PopCharac>")
    println("\t\t\tresource = ${msg.resultPack.popCharac.resource}")
}

internal fun parseASRFile(doc: Document): ASRMessage {
    val notificationMessageElem = doc.documentElement
            .findElementByTagName("wsnt:NotificationMessage")!!

    val message = ASRMessage()

    //parse the ProducerReference
    parseProducerReference(message.prodRef, notificationMessageElem)

    //parse the rest of the message
    parseMessage(message, notificationMessageElem.findElementByTagName("wsnt:Message")!!)

    return message
}

private fun parseMessage(message: ASRMessage, messageElem: Element) {
    val resultsPackageElem = messageElem.findElementByTagName("summRes:ResultsPackage")!!
    parseBenchmark(message, resultsPackageElem)
}

private fun parseBenchmark(message: ASRMessage, resultsPackageElem: Element) {
    //parse the results pack
    message.resultPack.cndc = resultsPackageElem.getAttribute("xmlns:cndc")
    message.resultPack.summRes = resultsPackageElem.getAttribute("xmlns:summRes")
    message.resultPack.popCharac.resource = resultsPackageElem.findElementByTagName("summRes:PopulationCharacteristics")!!
            .findElementByTagName("summRes:resource")!!
            .textContent

    //parse the benchmark
    val benchmarkElem = resultsPackageElem.findElementByTagName("summRes:benchmark")!!

    val benchmarkIdElem = benchmarkElem.findElementByTagName("summRes:benchMarkID")!!
    parseBenchmarkId(message.resultPack.benchmark.benchmarkId, benchmarkIdElem)

    //parse the rule results
    benchmarkElem.childNodes.forEach { elem ->
        if(elem.tagName == "summRes:ruleResult") {
            message.resultPack.benchmark.ruleResults.add(parseRuleResult(elem))
        }
    }
}

private fun parseBenchmarkId(benchmarkId: ASRBenchmarkId, benchmarkIdElem: Element) {
    benchmarkId.resource = benchmarkIdElem.findElementByTagName("cndc:resource")!!.textContent
    benchmarkId.recordIdentifier = benchmarkIdElem.findElementByTagName("cndc:record_identifier")!!.textContent
}

private fun parseRuleResult(ruleResultElem: Element): ASRRuleResult {
    assert(ruleResultElem.tagName == "summRes:ruleResult")

    val rr = ASRRuleResult()

    rr.ruleId = ruleResultElem.getAttribute("ruleID")
    rr.ident.data = ruleResultElem.findElementByTagName("summRes:ident")!!.textContent
    rr.ruleComplianceItem.ruleResult = ruleResultElem.findElementByTagName("summRes:ruleComplianceItem")!!.getAttribute("ruleResult")
    rr.ruleComplianceItem.result.count = ruleResultElem.findElementByTagName("summRes:ruleComplianceItem")!!.findElementByTagName("summRes:result")!!.getAttribute("count").toInt()

    return rr
}

