package com.example.dto

import kotlinx.serialization.Serializable

@Serializable
data class AuthorDTO(
    val authorId: Int,
    val authorName: String
)
