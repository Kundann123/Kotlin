package com.tdl.guaranteedsavings.dto

import java.time.LocalDateTime

data class PlansDTO(
    var planId: String,
    var insurerId: String,
    var planCode: String,
    var planName: String,
    var productType: String,
    var activeFlag: String,
    var createdByUser: String,
    var createdByDate: LocalDateTime,
    var modifiedByUser: String,
    var modifiedByDate: LocalDateTime


)
