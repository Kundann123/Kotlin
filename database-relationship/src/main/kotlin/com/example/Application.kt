package com.example

import com.example.config.Configuration
import com.example.config.DBConfig
import com.example.plugins.configureAuthentication
import com.example.plugins.configureSerialization
import com.example.plugins.configureStatusPages
import com.example.plugins.configureRouting
import io.ktor.server.application.Application

//fun main() {
//    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
//        .start(wait = true)
//}

fun main(args: Array<String>): Unit = io.ktor.server.cio.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    Configuration.initConfig(this.environment)
    configureAuthentication()
    configureSerialization()
    configureStatusPages()
    configureRouting()
    DBConfig.getDatabase()
}
