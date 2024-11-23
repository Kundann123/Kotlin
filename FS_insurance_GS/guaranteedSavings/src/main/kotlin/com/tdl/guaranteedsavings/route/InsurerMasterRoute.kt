package com.tdl.guaranteedsavings.route

import com.tdl.guaranteedsavings.di.kodein
import com.tdl.guaranteedsavings.dto.InsurerMasterDTO
import com.tdl.guaranteedsavings.service.InsurerMasterService
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

fun Application.configureInsurerMasterRoute() {
    val insurerMasterService by kodein.instance<InsurerMasterService>()
    val log: Logger = LoggerFactory.getLogger(javaClass)
    routing {
        route("/api/v1/guaranteedsavings/insurerMaster") {
            post("/saveInsurerWithInsurancePolicy") {
                val body = call.receive<InsurerMasterDTO>()
                log.info("Merchant Id Master Request Body:$body")
                insurerMasterService.saveInsurerWithInsurancePolicy(body).let {
                    call.respond(it)
                }
            }
        }
    }
}
