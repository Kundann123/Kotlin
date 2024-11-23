package com.example.route

import com.example.di.kodein
import com.example.dto.AuthorDTO
import com.example.service.AuthorService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.kodein.di.instance

fun Application.configureAuthorRoute() {
    val authorService by kodein.instance<AuthorService>()
    routing {
        route("/author") {
            post("/save") {
                val request = call.receive<AuthorDTO>()
                call.respond(authorService.saveAuthor(request))
            }

            get("/get-all") {
                val id = call.request.queryParameters["id"]?.toInt()
                call.respond(authorService.getAuthors(id))
            }

            get("/get-aa"){
                val id = call.request.queryParameters["id"]?.toInt()
                val response = authorService.authorWithArticles(id!!)
                call.respond(response.toString())
            }
        }
    }
}
