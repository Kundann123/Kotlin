package com.tdl.guaranteedsavings.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.varchar


interface InsurancePolicy: Entity<InsurancePolicy>
{
    val id: String
    val applicationNo: String
    val basePremiumAmount: String
    val certificateNumber: String
    val cgst: String
    val customerHash: String
    val igst: String
    val inceptionDate: String
    val incomeDuration: String
    val incomeFrequency: String
    val incomeType: String
    val insurancePolicyId: String
    val insurerId: String
    val investmentFrequency: String
    val isIntraState: String
    val isSmoker: String
    val otp: String
    val otpRefid: String
    val paymentMode: String
    val planId: String
    val policyActivated: String
    val policyEnddate: String
    val policyNumber: String
    val policyPayTerm: String
    val policyPdfUrl: String
    val policyStartDate: String
    val policyStatus: String
    val policyTerm: String
    val sgst: String
    val sumAssuredAmount: String
    val tataDiscount: String
    val taxAmount: String
    val remark: String
    val createdByDate: String
    val createdByUser: String
    val modifiedByDate: String
    val modifiedByUser: String

}

object  InsurancePolicies : Table<InsurancePolicy>("insurance_policy")
{
    val id = varchar("id").primaryKey().bindTo { it.id }
    val applicationNo = varchar("application_no").bindTo { it.applicationNo }
    val basePremiumAmount = varchar("base_premium_amount").bindTo { it.basePremiumAmount }
    val certificateNumber = varchar("certificate_number").bindTo { it.certificateNumber }
    val cgst = varchar("cgst").bindTo { it.cgst }
    val customerHash = varchar("customer_hash").bindTo { it.customerHash }
    val igst = varchar("igst").bindTo { it.igst }
    val inceptionDate = varchar("inception_date").bindTo { it.inceptionDate }
    val incomeDuration = varchar("income_duration").bindTo { it.incomeDuration }
    val incomeFrequency = varchar("income_frequency").bindTo { it.incomeFrequency }
    val incomeType = varchar("income_type").bindTo { it.incomeType }
    val insurancePolicyId = varchar("insurance_policy_id").bindTo { it.insurancePolicyId }
    val insuredId = varchar("insured_id").bindTo { it.insurerId}
    val investmentFrequency = varchar("investment_frequency").bindTo { it.investmentFrequency }
    val isIntraState = varchar("is_intra_state").bindTo { it.isIntraState }
    val isSmoker = varchar("isSmoker").bindTo { it.isSmoker }
    val otp = varchar("otp").bindTo { it.otp }
    val otpRefid = varchar("otp_refid").bindTo { it.otpRefid }
    val paymentMode = varchar("payment_mode").bindTo { it.paymentMode }
    val planId = varchar("plan_id").bindTo { it.planId }
    val policyActivated = varchar("policy_activated").bindTo { it.policyActivated }
    val policyEnddate = varchar("policy_enddate").bindTo { it.policyEnddate }
    val policyNumber = varchar("policy_number").bindTo { it.policyNumber }
    val policyPayTerm = varchar("policy_pay_term").bindTo { it.policyPayTerm }
    val policyPdfUrl = varchar("policy_pdf_url").bindTo { it.policyPdfUrl}
    val policyStartDate = varchar("policy_startdate").bindTo { it.policyStartDate }
    val policyStatus = varchar("policy_status").bindTo { it.policyStatus }
    val policyTerm = varchar("policy_term").bindTo { it.policyTerm }
    val sgst = varchar("sgst").bindTo { it.sgst }
    val sumAssuredAmount = varchar("sum_assured_amount").bindTo { it.sumAssuredAmount }
    val tataDiscount = varchar("tata_discount").bindTo { it.tataDiscount }
    val taxAmount = varchar("tax_amount").bindTo { it.taxAmount }
    val remark = varchar("remark").bindTo { it.remark }
    val createdByDate = varchar("created_by_date").bindTo { it.createdByDate }
    val createdByUser = varchar("created_by_user").bindTo { it.createdByUser }
    val modifiedByDate = varchar("modified_by_date").bindTo { it.modifiedByDate }
    val modifiedByUser = varchar("modified_by_user").bindTo { it.modifiedByUser }


}