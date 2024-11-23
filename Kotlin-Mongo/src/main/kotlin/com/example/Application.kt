package com.example

import com.example.dbconfig.Configuration
import com.example.dbconfig.MongoDBConfigFactory
import io.ktor.server.application.Application
import com.example.plugins.configureSerialization
import com.example.plugins.configureRouting
import com.example.plugins.configureStatusPages


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    Configuration.initConfig(this.environment)
    configureSerialization()
    configureRouting()
    configureStatusPages()
    MongoDBConfigFactory.getDatabase()
}
