package com.isenpai.scc.parsers

import com.isenpai.scc.dao.acas.*
import com.isenpai.scc.xml.findElementByTagName
import com.isenpai.scc.xml.map
import org.w3c.dom.Document
import org.w3c.dom.Element

internal fun parseARFFile(doc: Document): ARFMessage {
    val notificationMessageElem = doc.documentElement
            .findElementByTagName("wsnt:NotificationMessage")!!

    val message = ARFMessage()

    //parse the producer reference
    parseProducerReference(message.prodRef, notificationMessageElem)

    //parse the assessment report
    val assessmentReportElem = notificationMessageElem
            .findElementByTagName("wsnt:Message")!!
            .findElementByTagName("ar:AssessmentReport")!!
    parseAssessmentReport(message.ar, assessmentReportElem)

    return message
}

private fun parseAssessmentReport(ar: ARFAR, assessmentReportElem: Element) {
    //parse the attributes
    ar.ar = assessmentReportElem.getAttribute("xmlns:ar")
    ar.device = assessmentReportElem.getAttribute("xmlns:device")
    ar.cpe = assessmentReportElem.getAttribute("xmlns:cpe")
    ar.tagValue = assessmentReportElem.getAttribute("xmlns:tagged_value")
    ar.cndc = assessmentReportElem.getAttribute("xmlns:cndc")

    //parse each report object
    ar.reportObjects = assessmentReportElem.getElementsByTagName("ar:reportObject").map { reportObjectElem ->
        val reportObject = ARFReportObject()
        parseDevice(reportObject.device, reportObjectElem.findElementByTagName("ar:device")!!)
        reportObject
    }.toList()
}

private fun parseDevice(deviceObject: ARFDevice, deviceObjectElem: Element) {
    deviceObject.timestamp = deviceObjectElem.getAttribute("timestamp")

    parseDeviceId(deviceObject.deviceId, deviceObjectElem.findElementByTagName("device:device_ID")!!)
    parseIdentifiers(deviceObject.identifiers, deviceObjectElem.findElementByTagName("device:identifiers")!!)
    parseOpAttr(deviceObject.opAttr, deviceObjectElem.findElementByTagName("device:operational_attributes")!!)
    parseConfiguration(deviceObject.configuration, deviceObjectElem.findElementByTagName("device:configuration")!!)

    //parse the tagged values
    deviceObject.tagged = deviceObjectElem.getElementsByTagName("tagged_value:taggedString").map { taggedElem ->
        ARFTagged(
                name = taggedElem.getAttribute("name"),
                value = taggedElem.getAttribute("value")
        )
    }.toList()
}

private fun parseDeviceId(deviceId: ARFDeviceId, deviceIdElem: Element) {
    deviceId.resource = deviceIdElem.findElementByTagName("cndc:resource")!!.textContent
    deviceId.recordId = deviceIdElem.findElementByTagName("cndc:record_identifier")!!.textContent
}

private fun parseIdentifiers(identifiers: ARFIdentifier, identifierElem: Element) {
    fun parseFQDN(fqdnElem: Element): ARFIdFQDN {
        val fqdn = ARFIdFQDN()

        fqdn.realm = fqdnElem.findElementByTagName("device:realm")!!.textContent
        fqdn.hostName = fqdnElem.findElementByTagName("device:host_name")!!.textContent

        return fqdn
    }

    identifiers.fqdn = identifierElem.getElementsByTagName("device:FQDN")
            .map { fqdnElem -> parseFQDN(fqdnElem) }
            .toList()
}

private fun parseOpAttr(opAttr: ARFOpAttr, opAttrElem: Element) {
    opAttr.resource = opAttrElem.getAttribute("cndc:resource")
    opAttr.recordId = opAttrElem.getAttribute("cndc:record_identifier")
}

private fun parseConfiguration(cfg: ARFConfig, configElement: Element) {
    fun parseCpeInventory(platformName: ARFPlatformName, platformNameElem: Element) {
        platformName.assessedName.name = configElement.findElementByTagName("cpe:assessedName")!!.getAttribute("name")
    }

    parseNetConfig(cfg.networkConfig, configElement.findElementByTagName("device:network_configuration")!!)
    parseCpeInventory(cfg.cpeInv.platformName, configElement.findElementByTagName("device:cpe_inventory")!!
            .findElementByTagName("device:cpe_record")!!
            .findElementByTagName("cpe:platformName")!!)
}

fun parseNetConfig(netConfig: ARFNetConfig, netConfigElem: Element) {
    fun parseIp(ip: ARFIP, connectionIp: Element) {
        val ipv4Elem = connectionIp.findElementByTagName("cndc:IPv4")
        if(ipv4Elem != null) {
            ip.ipv4 = ipv4Elem.textContent
        }

        val ipv6Elem = connectionIp.findElementByTagName("cndc:IPv6")
        if(ipv6Elem != null) {
            ip.ipv6 = ipv6Elem.textContent
        }
    }

    netConfig.netIntId.id = netConfigElem.findElementByTagName("device:network_interface_ID")!!.textContent

    val hostData = netConfig.netIntId.hostData
    //hostData.macAddress = ?? //TODO how to get the mac address?
    parseIp(hostData.connectionIP, netConfigElem.findElementByTagName("device:host_network_data")!!)
}