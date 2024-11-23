package com.tdl.guaranteedsavings.dto

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("ACN")
    val acn: String,
    @SerializedName("PLNM")
    val plnm: String
)
