package com.tdl.guaranteedsavings.route

import com.tdl.guaranteedsavings.di.kodein
import com.tdl.guaranteedsavings.dto.UserDetailsDTO
import com.tdl.guaranteedsavings.service.UserDetailsService
import com.tdl.guaranteedsavings.service.impl.UserDetailsServiceImpl
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.kodein.di.instance

private fun Any.saveUserInfoWithInsurancePolicy(userDetailsInfo: UserDetailsDTO) {

}

fun Application.configureUserDetailsRoute() {
    val userDetailsService by kodein.instance<UserDetailsService>()

    routing {
        route("/api/v1/guaranteedsavings/userdetails") {
            post("/insertData") {
                val userDetailsData = call.receive<UserDetailsDTO>()
                val userDetailsService=UserDetailsServiceImpl()
                val result = userDetailsService.saveUserInfoWithInsurancePolicy(userDetailsData)
                call.respond(result)
            }
            post("/nomineeDetails") {
                val saveUserInfoWithInsurancePolicy = call.receive<UserDetailsDTO>()
                call.respond(userDetailsService.saveUserInfoWithInsurancePolicy(saveUserInfoWithInsurancePolicy))

            }

        }


    }

}