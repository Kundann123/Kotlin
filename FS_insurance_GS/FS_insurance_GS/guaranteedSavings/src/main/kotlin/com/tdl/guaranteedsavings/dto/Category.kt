package com.tdl.guaranteedsavings.dto

data class Category (
        val id:Int,
        val categoryName:String,
        val code:String,
        val createdAt:String,
        val updatedAt:String,
        val serviceClass:String,
        val templateName:String,
        val userInfoTemplate:String,
        val categoryGroup:String,
        val lineOfBusiness:String
)