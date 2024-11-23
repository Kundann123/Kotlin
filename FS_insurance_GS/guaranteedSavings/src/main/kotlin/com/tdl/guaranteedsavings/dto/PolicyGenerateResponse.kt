package com.tdl.guaranteedsavings.dto

data class PolicyGenerateResponse(
    val httpStatusCode: String,
    val message: String,
    val data: Data
)
