package com.tdl.guaranteedsavings.dto

import com.google.gson.annotations.SerializedName

data class DownloadFromCkycResponseDetails(
    @SerializedName("CkycDownloadResponseDetail")
    val ckycDownloadResponseDetail: CkycDownloadResponseDetail
)
