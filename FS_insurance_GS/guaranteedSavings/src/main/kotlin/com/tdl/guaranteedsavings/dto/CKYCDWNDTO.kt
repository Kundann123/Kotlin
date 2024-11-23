package com.tdl.guaranteedsavings.dto

import com.google.gson.annotations.SerializedName

data class CKYCDWNDTO(
    @SerializedName("CKYCNO")
    val ckycno: String,
    @SerializedName("DOB")
    val dob: String
)
