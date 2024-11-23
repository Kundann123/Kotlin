package com.example.model

data class MasterDTO(
        val id: String,
        val type: String,
        val name: String,
        val shortName: String,
        val activeFlag: String,
        val createdByUser: String,
        val createdByDate: String,
        val modifiedByUser: String,
        val modifiedByDate: String
)