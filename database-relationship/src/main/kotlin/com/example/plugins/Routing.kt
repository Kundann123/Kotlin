package com.example.plugins

import com.example.route.configureArticleRoute
import com.example.route.configureAuthorRoute
import com.example.route.authRoute
import io.ktor.server.application.Application

fun Application.configureRouting() {
    authRoute()
    configureAuthorRoute()
    configureArticleRoute()
}
