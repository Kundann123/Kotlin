package com.tdl.guaranteedsavings.dto

import com.google.gson.annotations.SerializedName

data class Request(

    @SerializedName("REQ")
    val req: REQDTO
)
