package com.tdl.guaranteedsavings.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.datetime
import org.ktorm.schema.varchar
import java.time.LocalDateTime

interface InsuredCustomer : Entity<InsuredCustomer> {
    val insuredId: String
    val firstName: String
    val lastName: String
    val phoneNumber: String
    val email: String
    val dob: String
    val gender: String
    val panNumber: String
    val panName: String
    val incomeDetail: String
    val height: String
    val weight: String
    val relationshipWithProposer: String
    val createdByUser: String
    val createdByDate: LocalDateTime
    val modifiedByUser: String
    val modifiedByDate: LocalDateTime
}
object InsuredCustomers : Table<InsuredCustomer>("insured_customer"){
    val insuredId = varchar("insured_id").primaryKey().bindTo { it.insuredId }
    val firstName = varchar("first_name").bindTo { it.firstName }
    val lastName = varchar("last_name").bindTo { it.lastName }
    val phoneNumber = varchar("phone_number").bindTo { it.phoneNumber }
    val email = varchar("email").bindTo { it.email }
    val dob = varchar("dob").bindTo { it.dob }
    val gender = varchar("gender").bindTo { it.gender }
    val panNumber = varchar("pan_number").bindTo { it.panNumber }
    val panName = varchar("pan_name").bindTo { it.panName }
    val incomeDetail = varchar("income_detail").bindTo { it.incomeDetail }
    val height = varchar("height").bindTo { it.height }
    val weight = varchar("weight").bindTo { it.weight }
    val relationshipWithProposer = varchar("relationship_with_proposer").bindTo { it.relationshipWithProposer }
    val createdByUser = varchar("created_by_user").bindTo { it.createdByUser }
    val createdByDate = datetime("created_by_date").bindTo { it.createdByDate }
    val modifiedByUser = varchar("modified_by_user").bindTo { it.modifiedByUser }
    val modifiedByDate = datetime("modified_by_date").bindTo { it.modifiedByDate }

}