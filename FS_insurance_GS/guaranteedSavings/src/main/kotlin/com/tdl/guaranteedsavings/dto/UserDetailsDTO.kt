package com.tdl.guaranteedsavings.dto

data class UserDetailsDTO(

    val custHash: String,
    val email: String,
    val panName: String,
    val bankIfscCode: String,
    val bankName: String,
    val branchName: String,
    val typeOfAccount: String,
    val annualIncomeRange: String,
    val relationshipWithNominee: String,
    val gender: String,
    val nomineeFullName: String,
    val heightFts: String,
    val heightInch: String,
    val weightKgs: String,
    val createdByUser: String,
    val createdByDatetime: String,
    val modifiedByUser: String,
    val modifiedByDatetime: String
)
