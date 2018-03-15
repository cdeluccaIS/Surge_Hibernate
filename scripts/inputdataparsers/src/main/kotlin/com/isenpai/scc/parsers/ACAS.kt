package com.isenpai.scc.parsers

import com.isenpai.scc.dao.acas.ACASProdRef
import com.isenpai.scc.xml.findElementByTagName
import org.w3c.dom.Element

internal fun parseProducerReference(prodRef: ACASProdRef, notificationMessageElem: Element) {
    assert(notificationMessageElem.tagName == "wsnt:NotificationMessage")

    //get the topic
    val topicElem = notificationMessageElem.findElementByTagName("wsnt:Topic")!!
    prodRef.topic = topicElem.textContent
    prodRef.topicDialect = topicElem.getAttribute("Dialect")

    //parse the producer reference
    val prodRefElem = notificationMessageElem.findElementByTagName("wsnt:ProducerReference")!!
    prodRef.address = (prodRefElem.findElementByTagName("wsa:Address") as Element).textContent

    //parse the metadata
    val metaElem = prodRefElem.findElementByTagName("wsa:Metadata")!!
    prodRef.meta.messageId = metaElem.findElementByTagName("wsa:MessageID")!!.textContent

    val taggedValueElem = metaElem.findElementByTagName("tagged_value:taggedString")!!
    prodRef.meta.tagName = taggedValueElem.getAttribute("name")
    prodRef.meta.tagValue = taggedValueElem.getAttribute("value")
}