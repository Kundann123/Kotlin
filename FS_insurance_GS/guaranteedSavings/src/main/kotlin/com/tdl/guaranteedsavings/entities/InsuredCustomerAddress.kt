package com.tdl.guaranteedsavings.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.datetime
import org.ktorm.schema.varchar
import java.time.LocalDateTime

interface InsuredCustomerAddress : Entity<InsuredCustomerAddress> {
    val addId: String
    val insuredId: String
    val addrFirstLine: String
    val addrSecondLine: String
    val city: String
    val state: String
    val pinCode: String
    val effectiveFrom: LocalDateTime
    val createdByUser: String
    val createdByDate: LocalDateTime
    val modifiedByUser: String
    val modifiedByDate: LocalDateTime
    val insuredCustomer: InsuredCustomer
}
object InsuredCustomerAddresses : Table<InsuredCustomerAddress>("insured_customer_address"){
    val addId = varchar("add_id").primaryKey().bindTo { it.addId }
    val insuredId = varchar("insured_id").references(InsuredCustomers){ it.insuredCustomer  }
    val addrFirstLine = varchar("addr_firstline").bindTo{ it.addrFirstLine}
    val addrSecondLine = varchar("addr_secondline").bindTo{ it.addrSecondLine}
    val city = varchar("city").bindTo{ it.city}
    val state = varchar("state").bindTo{ it.state}
    val pinCode = varchar("pincode").bindTo{ it.pinCode}
    val effectiveFrom = datetime("effective_from").bindTo{ it.effectiveFrom}
    val createdByUser = varchar("created_by_user").bindTo{ it.createdByUser}
    val createdByDate = datetime("created_by_date").bindTo{ it.createdByDate}
    val modifiedByUser = varchar("modified_by_user").bindTo{ it.modifiedByUser}
    val modifiedByDate = datetime("modified_by_date").bindTo{ it.modifiedByDate}

}