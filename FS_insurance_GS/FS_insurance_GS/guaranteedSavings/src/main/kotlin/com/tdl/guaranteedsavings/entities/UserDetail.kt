package com.tdl.guaranteedsavings.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface UserDetail : Entity<UserDetail> {
    val customerHash:String
    val email:String
    val phoneNumber:String
    val panName:String
    val ifscCode:String
    val bankName:String
    val branchName:String
    val typeOfAccount:String
    val incomeRange:String
    val relationshipWithNominee:String
    val gender:String
    val nomineesFullName:String
    val heightInFoot:Int
    val heightInInch:Int
    val weightInKg:Int
    val createdByUser:String
    val createdByDate:String
    val modifiedByUser:String
    val modifiedByDate:String
}
object UserDetails : Table<UserDetail>("user_details"){
    val customerHash=varchar("cust_hash").bindTo { it.customerHash }
    val email=varchar("email").bindTo { it.email }
    val phoneNumber=varchar("phone_number").bindTo { it.phoneNumber }.primaryKey()
    val panName=varchar("pan_name").bindTo { it.panName }
    val ifscCode=varchar("bank_ifsc_code").bindTo { it.ifscCode }
    val bankName=varchar("bank_name").bindTo { it.bankName }
    val branchName=varchar("branch_name").bindTo { it.branchName }
    val typeOfAccount=varchar("type_of_account").bindTo { it.typeOfAccount }
    val incomeRange=varchar("annual_income_range").bindTo { it.incomeRange }
    val relationshipWithNominee=varchar("relationship_with_nominee").bindTo { it.relationshipWithNominee }
    val gender=varchar("gender").bindTo { it.gender }
    val nomineesFullName=varchar("nominees_fullname").bindTo { it.nomineesFullName }
    val heightInFoot=int("height_fts").bindTo { it.heightInFoot }
    val heightInInch=int("height_inch").bindTo { it.heightInInch }
    val weightInKg=int("weight_kgs").bindTo { it.weightInKg }
    val createdByUser=varchar("created_by_user").bindTo { it.createdByUser }
    val createdByDate=varchar("created_by_date").bindTo { it.createdByDate }
    val modifiedByUser=varchar("modified_by_user").bindTo { it.modifiedByUser }
    val modifiedByDate=varchar("modified_by_date").bindTo { it.modifiedByDate }
}