package com.example.dto

import kotlinx.serialization.Serializable

@Serializable
data class ArticleDTO(
    val articleId: Int,
    val title: String,
    val authorRefId: Int
)
