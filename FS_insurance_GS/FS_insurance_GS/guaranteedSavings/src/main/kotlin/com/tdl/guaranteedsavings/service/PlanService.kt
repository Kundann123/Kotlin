package com.tdl.guaranteedsavings.service

import com.tdl.guaranteedsavings.dto.ApplicationResponse
import com.tdl.guaranteedsavings.dto.InsuranceDataRequest
import com.tdl.guaranteedsavings.dto.PlansDTO
import com.tdl.guaranteedsavings.entities.InsuranceApplication

interface PlanService {
    suspend fun savePlanDetails(body: PlansDTO): Int
    suspend fun getApplicationData(applicationData: InsuranceDataRequest): ArrayList<ApplicationResponse>
}