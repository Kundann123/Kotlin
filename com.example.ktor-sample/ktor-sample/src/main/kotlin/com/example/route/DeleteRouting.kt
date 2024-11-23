package com.example.route

import com.example.service.DeleteService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureDeleteRoute() {
    routing {
        get("/deleteById/{Id}"){  //Path Parameter
            val id=call.parameters["Id"]
            val deleteService = DeleteService()
            call.respond(deleteService.deleteMasterDate(id!!))
        }
    }
}