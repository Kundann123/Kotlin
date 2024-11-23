package com.tdl.guaranteedsavings.service

import com.tdl.guaranteedsavings.dto.InsuredCustomerAddressDTO

interface InsuredCustomer {
    fun saveInsuredCustomer(body: InsuredCustomerAddressDTO): Any
}