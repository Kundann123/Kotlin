package com.tdl.guaranteedsavings.dto

import com.google.gson.annotations.SerializedName

data class DownloadCkycDTO(
    @SerializedName("REQ")
    val req: REQDTO
)
