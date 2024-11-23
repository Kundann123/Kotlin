package com.example.route

import com.example.di.kodein
import com.example.dto.ArticleDTO
import com.example.service.ArticleService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.kodein.di.instance

fun Application.configureArticleRoute(){
    val articleService by kodein.instance<ArticleService>()

    routing {
        route("/article"){
            post("/save") {
                val request = call.receive<ArticleDTO>()
                call.respond(articleService.saveArticle(request))
            }

            get("/get-all") {
                val authorId = call.request.queryParameters["Id"]?.toInt()
                call.respond(articleService.getArticles(authorId))
            }
        }
    }
}
