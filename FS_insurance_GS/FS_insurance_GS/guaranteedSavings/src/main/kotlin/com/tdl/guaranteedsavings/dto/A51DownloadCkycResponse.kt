package com.tdl.guaranteedsavings.dto

import com.google.gson.annotations.SerializedName

data class A51DownloadCkycResponse(
    @SerializedName("DownloadFromCkycResponseDetails")
    val downloadFromCkycResponseDetails: DownloadFromCkycResponseDetails,
    @SerializedName("ParentCompany")
    val parentCompany: String,
    @SerializedName("RequestId")
    val requestId: String,
    @SerializedName("RequestStatus")
    val requestStatus: String,
    @SerializedName("xmlns:xsd")
    val xmlnsxsd: String,
    @SerializedName("xmlns:xsi")
    val xmlnsxsi: String
)
