package com.tdl.guaranteedsavings.service.impl

import com.tdl.guaranteedsavings.di.kodein
import com.tdl.guaranteedsavings.dto.InsuredCustomerAddressDTO
import com.tdl.guaranteedsavings.repository.InsuredCustomerRepository
import com.tdl.guaranteedsavings.service.InsuredCustomer
import io.ktor.http.*
import org.kodein.di.instance

class InsuredCustomerImpl : InsuredCustomer {
    private val insuredCustomerRepository by kodein.instance<InsuredCustomerRepository>()
    override fun saveInsuredCustomer(body: InsuredCustomerAddressDTO): Any {
        return insuredCustomerRepository.saveInsuredCustomer(body).let {
            if (it == 0) HttpStatusCode.NotModified
            else HttpStatusCode.OK
        }
    }
}