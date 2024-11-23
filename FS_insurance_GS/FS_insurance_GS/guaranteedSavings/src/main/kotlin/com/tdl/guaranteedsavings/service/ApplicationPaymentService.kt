package com.tdl.guaranteedsavings.service

import com.tdl.guaranteedsavings.dto.ApplicationPaymentDTO
import com.tdl.guaranteedsavings.dto.GetDetailsDTO
import com.tdl.guaranteedsavings.dto.UpdateDetailsDTO
import com.tdl.guaranteedsavings.repository.ApplicationPaymentRepository

class ApplicationPaymentService {
    private val applicationPaymentRepository = ApplicationPaymentRepository()
    suspend fun saveDetails(body: ApplicationPaymentDTO): Int {
        return applicationPaymentRepository.saveDetails(body)
    }

    suspend fun getDetails(body: GetDetailsDTO):Any {
     return applicationPaymentRepository.getDetails(body)
    }

    suspend fun updateDetails(body: UpdateDetailsDTO) {
        return applicationPaymentRepository.updateDetails(body)
    }

}