package com.tdl.guaranteedsavings.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.varchar

interface UserDetailsEntity: Entity<UserDetailsEntity>{

    val custHash: String
    val email: String
    val panName: String
    val bankIfscCode: String
    val bankName: String
    val branchName: String
    val typeOfAccount: String
    val annualIncomeRange: String
    val relationshipWithNominee: String
    val gender: String
    val nomineeFullName: String
    val heightFts: String
    val heightInch: String
    val weightKgs: String
    val createdByUser: String
    val createdByDatetime: String
    val modifiedByUser: String
    val modifiedByDatetime: String
}

object UserDetailsEntities : Table<UserDetailsEntity>("user_details") {
    val custHash = varchar("cust_hash").primaryKey().bindTo { it.custHash }
    val email = varchar("email").bindTo { it.email }
    val panName = varchar("pan_name").bindTo { it.panName }
    val bankIfscCode = varchar("bank_ifsc_code").bindTo { it.bankIfscCode }
    val bankName = varchar("bank_name").bindTo { it.bankName }
    val branchName = varchar("branch_name").bindTo { it.branchName }
    val typeOfAccount = varchar("type_of_account").bindTo { it.typeOfAccount }
    val annualIncomeRange = varchar("annual_income_range").bindTo { it.annualIncomeRange }
    val relationshipWithNominee = varchar("relationship_with_nominee").bindTo { it.relationshipWithNominee }
    val gender = varchar("gender").bindTo { it.gender }
    val nomineeFullName = varchar("nominee_full_name").bindTo { it.nomineeFullName }
    val heightFts = varchar("height_fts").bindTo { it.heightFts }
    val heightInch = varchar("height_inch").bindTo { it.heightInch }
    val weightKgs = varchar("weight_kgs").bindTo { it.weightKgs }
    val createdByUser = varchar("created_by_user").bindTo { it.createdByUser }
    val createdByDatetime = varchar("created_by_datetime").bindTo { it.createdByDatetime }
    val modifiedByUser = varchar("modified_by_user").bindTo { it.modifiedByUser }
    val modifiedByDatetime = varchar("modified_by_datetime").bindTo { it.modifiedByDatetime }

}

