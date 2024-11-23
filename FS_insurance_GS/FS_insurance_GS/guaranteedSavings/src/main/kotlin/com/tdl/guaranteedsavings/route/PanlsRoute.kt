package com.tdl.guaranteedsavings.route

import com.tdl.guaranteedsavings.di.kodein
import com.tdl.guaranteedsavings.dto.InsuranceDataRequest
import com.tdl.guaranteedsavings.dto.PlansDTO
import com.tdl.guaranteedsavings.service.PlanService
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import org.kodein.di.instance

fun Application.configurePlanRoute() {
    val planService by kodein.instance<PlanService>()

    routing {
        route("/api/guaranteedSavings/plan") {
            post("/insertData") {
                val planData = call.receive<PlansDTO>()
                val result = planService.savePlanDetails(planData)
                call.respond(result)
            }
            post("/insuranceApplication") {
                val applicationData = call.receive<InsuranceDataRequest>()
                val application = planService.getApplicationData(applicationData)
                call.respond(application)

            }

        }


    }

}