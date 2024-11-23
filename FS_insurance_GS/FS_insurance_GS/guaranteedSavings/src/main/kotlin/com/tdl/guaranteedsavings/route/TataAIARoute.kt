package com.tdl.guaranteedsavings.route

import com.tdl.guaranteedsavings.di.kodein
import com.tdl.guaranteedsavings.dto.PolicyGenerateDTO
import com.tdl.guaranteedsavings.dto.ValidateDocumentDTO
import com.tdl.guaranteedsavings.service.TataAIAService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.kodein.di.instance
import org.slf4j.Logger
import org.slf4j.LoggerFactory


fun Application.configureTataAIARoute() {
    val tataAIAService by kodein.instance<TataAIAService>()
    val log: Logger = LoggerFactory.getLogger(javaClass)
    routing {
        route("/api/guaranteedSavings/tataAIA") {
            post("/policyNumberGenerate") {
                val body = call.receive<PolicyGenerateDTO>()
                log.info("Policy Generate request body:$body")
                tataAIAService.policyGenerate(body).let {
                    call.respond(it)
                }
            }

            post("/validateDocument") {
                val body = call.receive<ValidateDocumentDTO>()
                log.info("Validate Document  request body:$body")
                tataAIAService.validateDocument(body).let {
                    call.respond(it)
                }
            }
        }
    }
}