package com.tdl.guaranteedsavings.dto

import com.google.gson.annotations.SerializedName

data class CkycDownloadResponseDetail(
    @SerializedName("CKYCIDDetails")
    val ckycIDDetails: String,
    @SerializedName("CKYCImageDetails")
    val ckycImageDetails: String,
    @SerializedName("CKYCRelatedPersonDetails")
    val ckycRelatedPersonDetails: String,
    @SerializedName("TransactionId")
    val transactionId: Int,
    @SerializedName("TransactionRejectionCode")
    val transactionRejectionCode: String,
    @SerializedName("TransactionRejectionDescription")
    val transactionRejectionDescription: String,
    @SerializedName("TransactionStatus")
    val transactionStatus: String
)
