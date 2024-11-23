package com.tdl.guaranteedsavings.route

import com.tdl.guaranteedsavings.di.kodein
import com.tdl.guaranteedsavings.dto.MerchantIdMasterDTO
import com.tdl.guaranteedsavings.service.MerchantIdMasterService
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

fun Application.configureMerchantIdMasterRoute() {
    val merchantIdMasterService by kodein.instance<MerchantIdMasterService>()
    val log: Logger = LoggerFactory.getLogger(javaClass)
    routing {
        route("/api/v1/guaranteedsavings/merchantIdMaster") {
            post("/saveMerchantIdMaster") {
                val body = call.receive<MerchantIdMasterDTO>()
                log.info("Merchant Id Master Request Body:$body")
                merchantIdMasterService.saveMerchantIdMaster(body).let {
                    call.respond(it)
                }
            }
            post("/updateMerchantIdMaster") {
                val body = call.receive<MerchantIdMasterDTO>()
                log.info("Merchant Id Master Request Body:$body")
                merchantIdMasterService.updateMerchantIdMaster(body).let {
                    call.respond(it)
                }
            }
        }
    }
}