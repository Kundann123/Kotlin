package com.tdl.guaranteedsavings.dto

import com.google.gson.annotations.SerializedName

data class REQDTO(
    @SerializedName("APP")
    val app: String,
    @SerializedName("CKYCDWN")
    val ckycdwn: List<CKYCDWNDTO>,
    @SerializedName("CONTYP")
    val contyp: String,
    @SerializedName("PLN")
    val pln: String,
    @SerializedName("CKYCSEARCH")
    val ckycSearch: List<CkycSearch>
)
