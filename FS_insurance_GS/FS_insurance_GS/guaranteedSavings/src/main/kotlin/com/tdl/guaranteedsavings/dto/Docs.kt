package com.tdl.guaranteedsavings.dto

data class Docs(
    val policyNo: String,
    val agentCode: String,
    val docCatID: String,
    val docId: String,
    val docType: String,
    val fileData: String,
    val docPageNo: String,
    val docFormat: String
)
