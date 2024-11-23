package com.tdl.guaranteedsavings.dto

import com.google.gson.annotations.SerializedName

data class DownloadCKYCResponseDTO(
    @SerializedName("A51DownloadCkycResponse")
    val a51DownloadCkycResponse: A51DownloadCkycResponse
)
