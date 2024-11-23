package com.tdl.guaranteedsavings.route

import com.tdl.guaranteedsavings.di.kodein
import com.tdl.guaranteedsavings.dto.MerchantIdMasterDTO
import com.tdl.guaranteedsavings.service.MerchantIdMasterService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.kodein.di.instance
import org.slf4j.Logger
import org.slf4j.LoggerFactory

fun Application.configureMerchantIdMasterRoute() {
    val merchantIdMasterService by kodein.instance<MerchantIdMasterService>()
    val log: Logger = LoggerFactory.getLogger(javaClass)
    routing {
        route("/api/guaranteedsavings/merchantIdMaster") {
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