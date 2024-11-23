package com.tdl.guaranteedsavings.dto

data class ValidateDocumentError(
    val httpStatusCode: String,
    val errorMessage: String
)
