package com.tdl.guaranteedsavings.service.impl

import com.tdl.guaranteedsavings.di.kodein
import com.tdl.guaranteedsavings.dto.ApplicationResponse
import com.tdl.guaranteedsavings.dto.InsuranceDataRequest
import com.tdl.guaranteedsavings.dto.PlansDTO
import com.tdl.guaranteedsavings.repository.PlanRepository
import com.tdl.guaranteedsavings.service.PlanService
import org.kodein.di.instance

class PlanServiceImpl:PlanService {

    val planRepository by kodein.instance<PlanRepository>()
    override suspend fun savePlanDetails(planData: PlansDTO):Int{

        return planRepository.savePlanDetails(planData)
    }

    override suspend fun getApplicationData(applicationData: InsuranceDataRequest): ArrayList<ApplicationResponse> {

        var applicationList= arrayListOf<ApplicationResponse>()
        var applicationEntity=planRepository.getApplicationData(applicationData)

        applicationEntity.map {
            applicationList.add(
                ApplicationResponse(
                    it.custHash,
                    it.isSmoker,
                    it.planId.planId,
                    it.planId.insurerId,
                    it.planId.planCode,
                    it.planId.planName,
                    it.planId.productType,
                    it.planId.activeFlag
            )
  )
        }

        return  applicationList
    }
}