package com.tdl.guaranteedsavings.dto

data class UserDetailResponseDTO(
    val email:String,
    val phoneNumber:String,
    val ifscCode:String,
    val bankName:String,
    val branchName:String,
    val typeOfAccount:String
)