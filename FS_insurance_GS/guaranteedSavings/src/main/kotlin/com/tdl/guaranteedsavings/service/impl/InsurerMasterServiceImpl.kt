package com.tdl.guaranteedsavings.service.impl

import com.tdl.guaranteedsavings.di.kodein
import com.tdl.guaranteedsavings.dto.InsurerMasterDTO
import com.tdl.guaranteedsavings.repository.InsurerMasterRepository
import com.tdl.guaranteedsavings.service.InsurerMasterService
import io.ktor.http.*
import org.kodein.di.instance

class InsurerMasterServiceImpl : InsurerMasterService {

    private val insurerMasterRepository by kodein.instance<InsurerMasterRepository>()

    override fun saveInsurerWithInsurancePolicy(insurerInfo: InsurerMasterDTO): Any {
        return insurerMasterRepository.saveInsurerWithInsurance(insurerInfo).let {
            if (it == 0) HttpStatusCode.NotModified
            else HttpStatusCode.OK
        }

    }
}