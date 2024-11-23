package com.example.exception

class UserBadRequestException(
    override val message: String?
) : Exception(message)