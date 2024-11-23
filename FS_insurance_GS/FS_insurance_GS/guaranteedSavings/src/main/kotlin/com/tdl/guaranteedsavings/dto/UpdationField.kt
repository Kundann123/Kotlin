package com.tdl.guaranteedsavings.dto

data class UpdationField (
    val customerName:String,
    val status:String,
    val totalCartFinalAmt:String,
    val totalTaxAmt:String,
    val modifiedByUser:String,
    val modifiedByDate:String
)