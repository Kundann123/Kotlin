package com.tdl.guaranteedsavings.route

import com.tdl.guaranteedsavings.di.kodein
import com.tdl.guaranteedsavings.dto.DownloadCkycDTO
import com.tdl.guaranteedsavings.dto.Request
import com.tdl.guaranteedsavings.service.CKYCService
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.routing
import io.ktor.server.routing.route
import io.ktor.server.routing.post
import org.kodein.di.instance
import org.slf4j.Logger
import org.slf4j.LoggerFactory


fun Application.configureCKYCRoute() {
    val ckycService by kodein.instance<CKYCService>()
    val log: Logger = LoggerFactory.getLogger(javaClass)
    routing {
        route("/api/guaranteedsavings/CKYC/") {
            post("/CKYCDownload") {
                val body = call.receive<DownloadCkycDTO>()
                log.info("Product Info request body:$body")
                ckycService.downloadCKYC(body).let {
                    call.respond(it)
                }
            }

            post("/CKYCSearch") {
                val body = call.receive<Request>()
                log.info("CKYC Search Request Body:$body")
                ckycService.searchCKYC(body).let {
                    call.respond(it)
                }

            }
        }
    }
}
