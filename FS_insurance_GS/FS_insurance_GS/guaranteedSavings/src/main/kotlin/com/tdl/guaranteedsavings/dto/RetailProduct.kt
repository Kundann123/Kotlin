package com.tdl.guaranteedsavings.dto


data class RetailProduct(
        val id:Int,
        val code:String,
        val name:String,
        val averageRating:Int,
        val totalRatings:Int,
        val category:Category,
        val recalculationStatus:String
)
