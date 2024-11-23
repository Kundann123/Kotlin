package com.tdl.guaranteedsavings.dto

data class PolicyGenerateError(

    val httpStatusCode: String,
    val message: String,
    val data: Data

)
