package com.tdl.guaranteedsavings.route

import com.tdl.guaranteedsavings.di.kodein
import com.tdl.guaranteedsavings.dto.InsurerMasterDTO
import com.tdl.guaranteedsavings.service.InsurerMasterService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.kodein.di.instance
import org.slf4j.Logger
import org.slf4j.LoggerFactory

fun Application.configureInsurerMasterRoute() {
    val insurerMasterService by kodein.instance<InsurerMasterService>()
    val log: Logger = LoggerFactory.getLogger(javaClass)
    routing {
        route("/api/guaranteedsavings/insurerMaster") {
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
