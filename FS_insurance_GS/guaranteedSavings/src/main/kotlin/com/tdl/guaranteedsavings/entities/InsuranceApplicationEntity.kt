package com.tdl.guaranteedsavings.entities

 import org.ktorm.entity.Entity
 import org.ktorm.schema.Table
 import org.ktorm.schema.varchar


interface InsuranceApplication:Entity<InsuranceApplication> {
    var planId: Plan
    var custHash:String
    var isSmoker:String

}

object InsuranceApplications: Table<InsuranceApplication>("insurance_application"){
    var planId=varchar("plan_id").references(Plans){ it.planId }
    var custHash=varchar("cust_hash").bindTo { it.custHash }
    var isSmoker=varchar("isSmoker").bindTo { it.isSmoker }

}