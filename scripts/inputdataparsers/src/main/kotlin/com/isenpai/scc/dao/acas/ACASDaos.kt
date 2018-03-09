package com.isenpai.scc.dao.acas

import java.util.*

data class ACASMeta(var uuid: UUID = UUID.randomUUID(),
                    var messageId: String = "",
                    var tagValue: String = "",
                    var tagName: String = "")

data class ACASProdRef(var uuid: UUID = UUID.randomUUID(),
                       var topic: String = "",
                       var topicDialect: String = "",
                       var address: String = "",
                       var meta: ACASMeta = ACASMeta()) {//FK: ACAS_Meta@uuid
    val metaUUID: UUID
        get() = meta.uuid
}

