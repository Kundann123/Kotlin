package com.tdl.guaranteedsavings

import com.tdl.guaranteedsavings.config.Configuration
import com.tdl.guaranteedsavings.config.DBConfig
import com.tdl.guaranteedsavings.plugins.configureCallLogging
import com.tdl.guaranteedsavings.plugins.configureRouting
import com.tdl.guaranteedsavings.plugins.configureSerialization
import com.tdl.guaranteedsavings.plugins.configureStatusPages
import io.ktor.server.application.Application

fun main(args: Array<String>): Unit =
    io.ktor.server.cio.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    Configuration.initConfig(this.environment)
    configureSerialization()
    configureRouting()
    configureCallLogging()
    configureStatusPages()
    DBConfig.getDatabaseConnection()
}
