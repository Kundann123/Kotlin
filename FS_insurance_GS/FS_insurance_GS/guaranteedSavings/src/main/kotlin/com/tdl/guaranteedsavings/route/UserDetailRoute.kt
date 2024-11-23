package com.tdl.guaranteedsavings.route

import com.tdl.guaranteedsavings.di.kodein
import com.tdl.guaranteedsavings.dto.GetUserDetailDTO
import com.tdl.guaranteedsavings.dto.UserDetailDTO
import com.tdl.guaranteedsavings.service.UserDetailService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.kodein.di.instance

fun Application.configureUserDetails(){
    val userDetailService by kodein.instance<UserDetailService>()
    routing {
        route("/api/v1/guaranteedsaving/userdetails"){
            post("/savedetails") {
                val body=call.receive<UserDetailDTO>()
                call.respond(userDetailService.saveUserDetails(body) )
            }

            post("/getdetails") {
                val body=call.receive<GetUserDetailDTO>()
                call.respond(userDetailService.getUserDetails(body))
            }


        }
    }

}

data class BodyException(
        var key:String,
        var excption:String

)