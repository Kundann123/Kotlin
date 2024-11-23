package com.example.plugins

import com.example.routes.configureUserRoute
import io.ktor.server.application.Application

fun Application.configureRouting() {
    configureUserRoute()
}
