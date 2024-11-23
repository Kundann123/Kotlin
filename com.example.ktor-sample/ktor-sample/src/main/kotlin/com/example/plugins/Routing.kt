package com.example.plugins

import com.example.DatabaseInserting
import com.example.model.MasterDTO
import com.example.route.configureDeleteRoute
import com.example.route.configureMasterRoute
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    configureMasterRoute()
    configureDeleteRoute()
    routing {
        get("/helloworld") {
            call.respondText("Hello World!")
        }
        get("/insertIntoDatabase") {
            val body = call.receive<MasterDTO>()
            val databaseInserting = DatabaseInserting()
            call.respond(databaseInserting.insertMasterDate(body))
        }
        post("/insertThroughPost") {
            val body = call.receive<MasterDTO>()
            val databaseInserting = DatabaseInserting()
            databaseInserting.insertMasterDate(body).let {
                call.respond("Result $it")
            }
        }
        post("/updateById") {
            val body = call.receive<MasterDTO>()
            val databaseInserting = DatabaseInserting()
            databaseInserting.updateMasterDate(body).let {
                call.respond("Result $it")
            }

        }
//            val databaseInserting = DatabaseInserting()
//            databaseInserting.deleteMasterDate(body).let {
//        post("/deleteById") {
//            val body = call.receive<MasterDTO>()
//                call.respond("Result $it")
//            }
//        }

    }
}

