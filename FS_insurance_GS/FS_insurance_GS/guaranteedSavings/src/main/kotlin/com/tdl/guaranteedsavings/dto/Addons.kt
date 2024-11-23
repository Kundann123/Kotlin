package com.tdl.guaranteedsavings.dto

import com.google.gson.annotations.SerializedName

data class Addons (
        val id:Int,
        @SerializedName("cover_code")
        val coverCode:String,
        @SerializedName("cover_name")
        val coverName:String,
        @SerializedName("base_premium")
        val basePremium:Int,
        val tax:Double,
        val premium:Double,
        val selected :Boolean,
        val term:Int,
        @SerializedName("insurance_cover_code")
        val insuranceCoverCode:String
)