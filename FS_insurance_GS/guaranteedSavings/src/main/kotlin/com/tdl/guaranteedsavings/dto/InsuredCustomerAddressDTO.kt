package com.tdl.guaranteedsavings.dto

import java.time.LocalDateTime

data class InsuredCustomerAddressDTO(
    val addId: String,
    val insuredId: String,
    val addrFirstLine: String,
    val addrSecondLine: String,
    val city: String,
    val state: String,
    val pinCode: String,
    val effectiveFrom: LocalDateTime,
    val createdByUser: String,
    val createdByDate: LocalDateTime,
    val modifiedByUser: String,
    val modifiedByDate: LocalDateTime,
    val insuredCustomer: InsuredCustomerDTO
)
