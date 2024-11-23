package com.tdl.guaranteedsavings.route

import com.tdl.guaranteedsavings.di.kodein
import com.tdl.guaranteedsavings.dto.InsuredCustomerAddressDTO
import com.tdl.guaranteedsavings.service.InsuredCustomer
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.kodein.di.instance
import org.slf4j.Logger
import org.slf4j.LoggerFactory

fun Application.configureInsuredCustomer() {
    val insuredCustomer by kodein.instance<InsuredCustomer>()
    val log: Logger = LoggerFactory.getLogger(javaClass)
    routing {
        route("/api/guaranteedsavings/insuredCustomer") {
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