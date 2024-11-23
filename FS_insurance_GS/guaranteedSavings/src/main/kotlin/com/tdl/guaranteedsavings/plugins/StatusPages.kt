package com.tdl.guaranteedsavings.plugins

import com.tdl.guaranteedsavings.dto.MessageDTO
import com.tdl.guaranteedsavings.exception.GSInternalServerException
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respond
import org.slf4j.LoggerFactory

fun Application.configureStatusPages() {
    val log = LoggerFactory.getLogger(javaClass)
    install(StatusPages) {
        exception<GSInternalServerException> { call, cause ->
            log.error("Exception occurred while calling api" + cause.stackTraceToString())
            call.respond(HttpStatusCode.InternalServerError, MessageDTO(cause.message!!))
        }
    }
}
