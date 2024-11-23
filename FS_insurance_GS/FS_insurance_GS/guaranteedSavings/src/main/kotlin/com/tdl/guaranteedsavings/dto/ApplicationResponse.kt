package com.tdl.guaranteedsavings.dto

data class ApplicationResponse(
    var custHash: String,
    var isSmoker: String,
    var planId: String,
    var insurarId: String,
    var planCode: String,
    var planName: String,
    var productType: String,
    var activeFlag: String


)
