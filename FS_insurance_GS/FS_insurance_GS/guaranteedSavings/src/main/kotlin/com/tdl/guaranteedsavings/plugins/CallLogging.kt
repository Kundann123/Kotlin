package com.tdl.guaranteedsavings.plugins

import ch.qos.logback.classic.LoggerContext
import com.tdl.guaranteedsavings.config.Configuration
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.callloging.CallLogging
import io.ktor.server.request.path
import io.ktor.server.request.httpMethod
import org.slf4j.LoggerFactory
import org.slf4j.event.Level

fun Application.configureCallLogging() {
    val level = when (Configuration.env.appLoggingLevel) {
        "ERROR" -> Level.ERROR
        "INFO" -> Level.INFO
        else -> Level.DEBUG
    }

    install(CallLogging) {
        this.level = level
        filter { call ->
            call.request.path().startsWith("/")
        }
    }

    val loggerContext = LoggerFactory.getILoggerFactory() as LoggerContext
    loggerContext.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME).level =
        ch.qos.logback.classic.Level.toLevel(Configuration.env.appLoggingLevel)
}