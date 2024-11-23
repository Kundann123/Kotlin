package com.tdl.guaranteedsavings.dto

import com.google.gson.annotations.SerializedName

data class CkycSearch(

    @SerializedName("INIDTYP")
    val inidtyp: String,
    @SerializedName("INIDNO")
    val inidno: String
)
