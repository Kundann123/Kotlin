package com.example.plugins

import io.ktor.server.application.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
    }
}
