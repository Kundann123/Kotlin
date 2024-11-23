package com.tdl.guaranteedsavings.dto


data class InsurerMasterDTO(

    val insurerId: String,
    val insurerName: String,
    val insurerDesc: String,
    val agentCode: String,
    val activeFlag: String,
    val createdByUser: String,
    val createdByDate: String,
    val modifiedByUser: String,
    val modifiedByDate: String,
    val insurancePolicy: InsurancePolicyDTO

)
