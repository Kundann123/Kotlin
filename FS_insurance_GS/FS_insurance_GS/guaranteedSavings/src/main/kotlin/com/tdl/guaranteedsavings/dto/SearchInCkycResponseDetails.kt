package com.tdl.guaranteedsavings.dto

import com.google.gson.annotations.SerializedName

data class SearchInCkycResponseDetails(

    @SerializedName("CKYCIDDetails")
    val ckycIdDetails: CkycIdDetails,
    @SerializedName("CKYCRequestId")
    val ckycRequestId: String,
    @SerializedName("TransactionStatus")
    val transactionStatus: String,
    @SerializedName("CKYCUpdatedDate")
    val ckycUpdatedDate: String,
    @SerializedName("CKYCRequestDate")
    val ckycRequestDate: String,
    @SerializedName("CKYCName")
    val ckycName: String,
    @SerializedName("CKYCPhotoImageType")
    val ckycPhotoImageType: String,
    @SerializedName("CKYCPhotoBytes")
    val ckycPhotoBytes: String,
    @SerializedName("TransactionId")
    val transactionId: Int,
    @SerializedName("CKYCAge")
    val ckycAge: Int,
    @SerializedName("CKYCAccType")
    val ckycAccType: String,
    @SerializedName("ApplicationFormNo")
    val applicationFormNo:String,
    @SerializedName("CKYCID")
    val ckycId: Any,
    @SerializedName("CKYCAvailable")
    val ckycAvailable: String,
    @SerializedName("CKYCGenDate")
    val ckycGenDate: String,
    @SerializedName("CKYCPhoto")
    val ckycPhoto: String,
    @SerializedName("CKYCFatherName")
    val ckycFatherName: String,
    @SerializedName("CKYCRemarks")
    val ckycRemarks: String

)
