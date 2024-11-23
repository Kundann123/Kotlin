package com.tdl.guaranteedsavings.dto

import com.google.gson.annotations.SerializedName

data class CkycSearchResponse(

    @SerializedName("A50SearchInCkycResponse")
    val a50SearchInCkycResponse: A50SearchInCkycResponse
)
