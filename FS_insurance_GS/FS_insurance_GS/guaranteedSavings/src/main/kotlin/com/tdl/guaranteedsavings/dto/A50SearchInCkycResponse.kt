package com.tdl.guaranteedsavings.dto

import com.google.gson.annotations.SerializedName

data class A50SearchInCkycResponse(

    @SerializedName("xmlns:xsd")
    val xmlnsxsd: String,
    @SerializedName("ParentCompany")
    val parentCompany: String,
    @SerializedName("Details")
    val details: DetailsDTO,
    @SerializedName("RequestId")
    val requestId: String,
    @SerializedName("xmlns:xsi")
    val xmlnsxsi: String,
    @SerializedName("RequestStatus")
    val requestStatus: String
)
