package com.example.plugins

import com.example.exception.BadRequest
import com.example.exception.InternalServerException
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import org.slf4j.LoggerFactory
import javax.naming.AuthenticationException

fun Application.configureStatusPages() {
    install(StatusPages) {
        val log = LoggerFactory.getLogger(javaClass)
        exception<Throwable> { call, cause ->
            log.error("General exception :: need to check closely")
            call.respondText(text = "409: $cause", status = HttpStatusCode.Conflict)
        }

        exception<InternalServerException> { call, cause ->
            log.error("InternalServerError exception :: ${cause.stackTraceToString()}")
            call.respond(HttpStatusCode.InternalServerError, cause.stackTraceToString())
        }

        exception<BadRequest> { call, cause ->
            log.error("BadRequest exception :: ${cause.stackTraceToString()}")
            call.respond(HttpStatusCode.BadRequest, cause.stackTraceToString())
        }

        exception<AuthenticationException>{ call, cause ->
            log.error("BadRequest exception :: ${cause.stackTraceToString()}")
            call.respond(HttpStatusCode.Unauthorized, cause.stackTraceToString())
        }
    }
}