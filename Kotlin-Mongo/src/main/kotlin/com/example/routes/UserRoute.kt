package com.example.routes

import com.example.di.kodein
import com.example.dto.UserDTO
import com.example.service.UserService
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.routing
import io.ktor.server.routing.route
import io.ktor.server.routing.post
import io.ktor.server.routing.get
import org.kodein.di.instance

fun Application.configureUserRoute(){
    val userService by kodein.instance<UserService>()

    routing {
        route("/user"){
            post("/addUser"){
                val body=call.receive<UserDTO>()
                call.respond(userService.addUser(body))
            }

            get("/getUser/{ID}"){
                val body=call.parameters["ID"]
                call.respond(userService.run { getUser(body!!) }!!)
            }

            get("/deleteUser/{ID}"){
                val body=call.parameters["ID"]
                call.respond(userService.deleteUser(body))
            }

            post("/updateUser"){
                val body=call.receive<UserDTO>()
                call.respond(userService.updateUser(body))
            }
        }
    }
}