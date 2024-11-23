package com.tdl.guaranteedsavings.route

import com.tdl.guaranteedsavings.di.kodein
import com.tdl.guaranteedsavings.dto.InsuredCustomerAddressDTO
import com.tdl.guaranteedsavings.service.InsuredCustomer
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

fun Application.configureInsuredCustomer() {
    val insuredCustomer by kodein.instance<InsuredCustomer>()
    val log: Logger = LoggerFactory.getLogger(javaClass)
    routing {
        route("/api/v1/guaranteedsavings/insuredCustomer") {
            post("/saveInsuredCustomer") {
                val body = call.receive<InsuredCustomerAddressDTO>()
                log.info("Product Info request body:$body")
                insuredCustomer.saveInsuredCustomer(body).let {
                    call.respond(it)
                }
            }
        }
    }
}