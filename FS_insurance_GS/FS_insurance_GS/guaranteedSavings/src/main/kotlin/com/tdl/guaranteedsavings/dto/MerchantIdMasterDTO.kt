package com.tdl.guaranteedsavings.dto

import com.google.gson.annotations.SerializedName

data class MerchantIdMasterDTO(

    val id: String,
    @SerializedName("insurer_id")
    val insurerId: String,
    @SerializedName("merchant_id")
    val merchantId: String,
    @SerializedName("merchant_name")
    val merchantName: String,
    @SerializedName("terminal_id")
    val terminalId: String,
    @SerializedName("active_flag")
    val activeFlag: String,
    @SerializedName("created_by_user")
    val createdByUser: String,
    @SerializedName("created_by_date")
    val createdByDate: String,
    @SerializedName("modified_by_user")
    val modifiedByUser: String,
    @SerializedName("modifiedByDate")
    val modifiedByDate: String
)
