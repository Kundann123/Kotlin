package com.tdl.guaranteedsavings.route

import com.tdl.guaranteedsavings.di.kodein
import com.tdl.guaranteedsavings.dto.GeneratedResponse
import com.tdl.guaranteedsavings.dto.PolicyGenerateDTOMOCK
import com.tdl.guaranteedsavings.service.PolicyGeneratorService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.kodein.di.instance

fun Application.configurePolicyNumberGeneration() {
    val policyGenarator by kodein.instance<PolicyGeneratorService>()
    routing {
        route("/api/v1/integration/gs") {
            post("/generatepolicyno") {
                val body = call.receive<PolicyGenerateDTOMOCK>()
                call.respond(
                    policyGenarator.generatePolicyNumber(body)
                )

            }
            get("/getinfo"){
                call.respond(policyGenarator.getInformation())
            }
        }
    }
}