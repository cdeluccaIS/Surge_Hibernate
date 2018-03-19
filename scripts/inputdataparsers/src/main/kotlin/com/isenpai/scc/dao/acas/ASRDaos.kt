package com.isenpai.scc.dao.acas

import java.util.*

data class ASRMessage(var uuid: UUID = UUID.randomUUID(),
                      var prodRef: ACASProdRef = ACASProdRef(), //FK: ACAS_ProRef@uuid
                      var resultPack: ASRResultsPackage = ASRResultsPackage()) {//FK: ACAS_ASR_ResultsPackage@uuid
    val prodRefUUID: UUID
        get() = prodRef.uuid
    val resultPackUUID: UUID
        get() = resultPack.uuid
}

data class ASRResultsPackage(var uuid: UUID = UUID.randomUUID(),
                             var cndc: String = "",
                             var summRes: String = "",
                             val benchmark: ASRBenchmark = ASRBenchmark(), //TODO this deviates from the schema -- I'm just putting this here for now
                             var popCharac: ASRPopulationCharacteristics = ASRPopulationCharacteristics()) {//FK: ACAS_ASR_PopulationCharacteristics@uuid
    val benchmarkUUID: UUID
        get() = benchmark.uuid
    val popCharacUUID: UUID
        get() = popCharac.uuid
}

data class ASRPopulationCharacteristics(var uuid: UUID = UUID.randomUUID(),
                                        var resource: String = "")

data class ASRBenchmark(var uuid: UUID = UUID.randomUUID(),
                        val benchmarkId: ASRBenchmarkId = ASRBenchmarkId(), //FK: ACAS_ASR_BenchMarkID@uuid
                        var ruleResults: MutableList<ASRRuleResult> = mutableListOf()) {//FK: ACAS_ASR_RuleResult@uuid
    val benchmarkIdUUID: UUID
        get() = benchmarkId.uuid
    val ruleResultsUUIDs: List<UUID>
        get() = ruleResults.map { it.uuid }
}

data class ASRBenchmarkId(var uuid: UUID = UUID.randomUUID(),
                          var resource: String = "",
                          var recordIdentifier: String = "")

data class ASRRuleResult(var uuid: UUID = UUID.randomUUID(),
                         var ruleId: String = "",
                         var ident: ASRIdent = ASRIdent(), //FK: ACAS_ASR_Ident@uuid
                         var ruleComplianceItem: ASRRuleComplianceItem = ASRRuleComplianceItem()) {//FK: ACAS_ASR_RuleComplianceItem@uuid
    val identUUID: UUID
        get() = ident.uuid
    val ruleComplianceItemUUID: UUID
        get() = ruleComplianceItem.uuid
}

data class ASRIdent(var uuid: UUID = UUID.randomUUID(),
                    var data: String = "")

data class ASRRuleComplianceItem(var uuid: UUID = UUID.randomUUID(),
                                 var ruleResult: String = "",
                                 var result: ASRResult = ASRResult()) {//FK: ACAS_ASR_Result@uuid
    val resultUUID: UUID
        get() = result.uuid
}

data class ASRResult(var uuid: UUID = UUID.randomUUID(),
                     var count: Int = 0)
