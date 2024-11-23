package com.tdl.guaranteedsavings.dto

import java.time.LocalDateTime

data class InsuredCustomerDTO(
    val insuredId: String,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val dob: String,
    val gender: String,
    val panNumber: String,
    val panName: String,
    val incomeDetail: String,
    val height: String,
    val weight: String,
    val relationshipWithProposer: String,
    val createdByUser: String,
    val createdByDate: LocalDateTime,
    val modifiedByUser: String,
    val modifiedByDate: LocalDateTime
)
