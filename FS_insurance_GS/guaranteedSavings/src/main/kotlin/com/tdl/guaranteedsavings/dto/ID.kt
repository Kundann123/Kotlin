package com.tdl.guaranteedsavings.dto

import com.google.gson.annotations.SerializedName

data class ID(

    @SerializedName("CKYCIDRemarks")
    val ckycIdRemarks: String,
    @SerializedName("CKYCAvailableIDType")
    val ckycAvailableIdType: String,
    @SerializedName("CKYCAvailableIDTypeStatus")
    val ckycAvailableIdTypeStatus: String

)
