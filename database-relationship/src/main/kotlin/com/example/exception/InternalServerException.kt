package com.example.exception

class InternalServerException(override val message: String) : Exception(message)