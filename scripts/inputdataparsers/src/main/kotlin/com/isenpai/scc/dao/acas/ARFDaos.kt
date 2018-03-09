package com.isenpai.scc.dao.acas

import java.time.Instant
import java.util.*

data class ARFMessage(var uuid: UUID = UUID.randomUUID(),
                      var prodRef: ACASProdRef = ACASProdRef(), //FK: ACAS_ProdRef@uuid
                      var ar: ARFAR = ARFAR()) { //FK: ACAS_ARF_AR@uuid
    val prodRefUUID: UUID
        get() = prodRef.uuid
    val arUUID: UUID
        get() = ar.uuid
}

data class ARFAR(var uuid: UUID = UUID.randomUUID(),
                 var ar: String = "",
                 var device: String = "",
                 var cpe: String = "",
                 var tagValue: String = "",
                 var cndc: String = "",
                 var reportObjects: List<ARFReportObject> = mutableListOf()) { //TODO this deviates from the schema -- I'm just putting this here for now
    val reportObjectUUIDs: List<UUID>
        get() = reportObjects.map{ it.uuid }
}

data class ARFReportObject(var uuid: UUID = UUID.randomUUID(),
                           var device: ARFDevice = ARFDevice()) {
    val deviceUUID: UUID
        get() = device.uuid
}

data class ARFDevice(var uuid: UUID = UUID.randomUUID(),
                     var deviceId: ARFDeviceId = ARFDeviceId(), //FK: ACAS_ARF_deviceID@uuid
                     var identifiers: ARFIdentifier = ARFIdentifier(), //FK: ACAS_ARF_Identifier@uuid
                     var opAttr: ARFOpAttr = ARFOpAttr(), //FK: ACAS_ARF_OPATTR@uuid
                     var configuration: ARFConfig = ARFConfig(), //FK: ACAS_ARF_Config@uuid
                     var timestamp: String = "", //TODO should this be of a different type?
                     var tagged: List<ARFTagged> = mutableListOf()) { //FK: ACAS_ARF_Tagged@uuid
    val deviceIdUUID: UUID
        get() = deviceId.uuid

    val taggedUUIDs: List<UUID>
        get() = tagged.map { it.uuid }
}

data class ARFDeviceId(var uuid: UUID = UUID.randomUUID(),
                       var resource: String = "",
                       var recordId: String = "")

data class ARFIdentifier(var uuid: UUID = UUID.randomUUID(),
                         var fqdn: List<ARFIdFQDN> = mutableListOf()) { //FK: ACAS_ARF_ID_FQDN@uuid
    val fqdnUUIDs: List<UUID>
        get() = fqdn.map { it.uuid }
}

data class ARFOpAttr(var uuid: UUID = UUID.randomUUID(),
                     var resource: String = "",
                     var recordId: String = "")

data class ARFConfig(var uuid: UUID = UUID.randomUUID(),
                     var networkConfig: ARFNetConfig = ARFNetConfig(), //FK: ACAS_ARF_NETCONFIG@uuid
                     var cpeInv: ARFCpeRecord = ARFCpeRecord()) { //FK: ACAS_ARF_cpeRecord@uuid
    val networkConfigUUID: UUID
        get() = networkConfig.uuid

    val cpeInvUUID: UUID
        get() = cpeInv.uuid
}

data class ARFTagged(var uuid: UUID = UUID.randomUUID(),
                     var name: String = "",
                     var value: String = "")

data class ARFIdFQDN(var uuid: UUID = UUID.randomUUID(),
                   var realm: String = "",
                   var hostName: String = "")

data class ARFNetConfig(var uuid: UUID = UUID.randomUUID(),
                        var netIntId: ARFNetIntId = ARFNetIntId()) { //FK: ACAS_ARF_NETINTID@uuid
    val netIntIdUUID: UUID
        get() = netIntId.uuid
}

data class ARFCpeRecord(var uuid: UUID = UUID.randomUUID(),
                        var platformName: ARFPlatformName = ARFPlatformName()) { //FK: ACAS_ARF_PlatformName@uuid
    val platformNameUUID: UUID
        get() = platformName.uuid
}

data class ARFNetIntId(var uuid: UUID = UUID.randomUUID(),
                       var id: String = "",
                       var hostData: ARFHostData = ARFHostData()) { //FK: ACAS_ARF_HOSTDATA@uuid
    val hostDataUUID: UUID
        get() = hostData.uuid
}

data class ARFPlatformName(var uuid: UUID = UUID.randomUUID(),
                           var assessedName: ARFAN = ARFAN()) { //FK: ACAS_ARF_AN@uuid
    val assessedNameUUID: UUID
        get() = assessedName.uuid
}

data class ARFHostData(var uuid: UUID = UUID.randomUUID(),
                       var macAddress: String = "",
                       var connectionIP: ARFIP = ARFIP()) { //FK: ACAS_ARF_IP@uuid
    val connectionIPUUID: UUID
        get() = connectionIP.uuid
}

data class ARFAN(var uuid: UUID = UUID.randomUUID(),
                 var name: String = "")

data class ARFIP(var uuid: UUID = UUID.randomUUID(),
                 var ipv4: String = "",
                 var ipv6: String = "")