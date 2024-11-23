package com.tdl.guaranteedsavings.plugins

import com.tdl.guaranteedsavings.route.*
import io.ktor.server.application.Application

fun Application.configureRouting() {
    configureCKYCRoute()
    configureMerchantIdMasterRoute()
    configureInsurerMasterRoute()
    configureTataAIARoute()
    configureInsuredCustomer()
    configurePlanRoute()
    configurePolicyNumberGeneration()
    configureApplicationPayments()
    configureUserDetails()
}
