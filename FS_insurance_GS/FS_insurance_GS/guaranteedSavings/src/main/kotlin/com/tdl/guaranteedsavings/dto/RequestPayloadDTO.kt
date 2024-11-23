package com.tdl.guaranteedsavings.dto

import com.google.gson.annotations.SerializedName

data class RequestPayloadDTO(
    @SerializedName("AC")
    val ac: String,
    @SerializedName("PT")
    val pt: String,
    @SerializedName("APPID")
    val appId: String,
    @SerializedName("ACN")
    val acn: String
)
