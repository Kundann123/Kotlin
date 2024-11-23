package com.example.route

import com.example.model.MasterDTO
import com.example.service.MasterService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureMasterRoute() {
    routing {
        post("/saveMasterDetails") {
            val body = call.receive<MasterDTO>()
            val masterService = MasterService()
            call.respond(masterService.saveMasterDetails(body))
        }
    }
}
