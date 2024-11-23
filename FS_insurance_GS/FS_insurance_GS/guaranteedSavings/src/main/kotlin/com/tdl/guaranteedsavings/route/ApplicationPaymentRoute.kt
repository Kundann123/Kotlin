package com.tdl.guaranteedsavings.route

import com.tdl.guaranteedsavings.di.kodein
import com.tdl.guaranteedsavings.dto.ApplicationPaymentDTO
import com.tdl.guaranteedsavings.dto.GetDetailsDTO
import com.tdl.guaranteedsavings.dto.UpdateDetailsDTO
import com.tdl.guaranteedsavings.service.ApplicationPaymentService
import com.tdl.guaranteedsavings.service.InsuredCustomer
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.kodein.di.instance
import org.slf4j.Logger
import org.slf4j.LoggerFactory

fun Application.configureApplicationPayments() {
    val applicationPaymentService by kodein.instance<ApplicationPaymentService>()
    routing {
        route("/api/application/payments") {
            post("/saveDetails") {
                val body = call.receive<ApplicationPaymentDTO>()
                val log: Logger = LoggerFactory.getLogger(javaClass)
                log.info("$body")
                call.respond(applicationPaymentService.saveDetails(body))
            }
            post("/getDetails") {
                val body=call.receive<GetDetailsDTO>()
                call.respond( applicationPaymentService.getDetails(body))
            }

            post("/updateById"){
                val body=call.receive<UpdateDetailsDTO>()
                call.respond(applicationPaymentService.updateDetails(body))
            }
        }
    }
}