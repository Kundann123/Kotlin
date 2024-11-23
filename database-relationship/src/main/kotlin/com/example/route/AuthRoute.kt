package com.example.route

import com.example.config.JwtConfig
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.auth.authenticate
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.routing
import io.ktor.server.routing.route
import io.ktor.server.routing.get
import io.ktor.server.routing.post


fun Application.authRoute() {
    routing {
        route("/token") {
            get {
                val token = JwtConfig.generateToken("your_secret_key", "your_app", "your_audience", 2)
                call.respond(mapOf("token" to token))
            }
        }

        authenticate {
            route("/protected") {
                get("/sample-data") {
                    call.respondText("Hello World!")
                }

                post("/add") {
                    val firstNum = call.parameters["firstNum"]?.toInt()
                    val secondNum = call.parameters["secondNum"]?.toInt()
                    call.respondText("Result == ${firstNum!! + secondNum!!}")
                }
            }
        }
    }
}
