package com.tdl.guaranteedsavings.dto

import com.google.gson.annotations.SerializedName

data class PolicyGenerateDTOMOCK(
    val platformParameters: PlatformParametersMOCK,
    val requestPayload: RequestPayloadMOCK
)

data class RequestPayloadMOCK(
    @SerializedName("AC")
    val ac: String,
    @SerializedName("PT")
    val pt: String,
    @SerializedName("APPID")
    val appId: String,
    @SerializedName("ACN")
    val acn: String
)

data class PlatformParametersMOCK(
    val provider: String
)