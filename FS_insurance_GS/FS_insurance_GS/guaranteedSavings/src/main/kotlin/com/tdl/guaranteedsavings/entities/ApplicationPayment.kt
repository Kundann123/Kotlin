package com.tdl.guaranteedsavings.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.varchar

interface ApplicationPayment : Entity<ApplicationPayment> {
    val paymentId:String
    val orderId:String
    val orderRetrialId:String
    val merchantId:String
    val tPayCustomerId:String
    val tcpNum:String
    val customerName:String
    val merchantName:String
    val terminalType:String
    val billCategory:String
    val status:String
    val subStatus:String
    val failureReason:String
    val totalCartAmount:String
    val totalCartFinalAmt:String
    val totalTaxAmt:String
    val storeCode:String
    val prepaidAmt:String
    val typeOfRequest:String
    val callBackUrl:String
    val timeout:String
    val timeRemaining:String
    val tdlOrderTransactId:String
    val reversalId:String
    val tataPayPwaUrl:String
    val errorInfo:String
    val warningInfo:String
    val statusInfo:String
    val createdByUser:String
    val createdByDate:String
    val modifiedByUser:String
    val modifiedByDate:String
}
object ApplicationPayments : Table<ApplicationPayment>("application_payments"){
    val paymentId=varchar("payment_id").bindTo { it.paymentId }.primaryKey()
    val orderId=varchar("order_id").bindTo { it.orderId }
    val orderRetrialId=varchar("order_retrial_id").bindTo { it.orderRetrialId }
    val merchantId=varchar("merchant_id").bindTo { it.merchantId }
    val tPayCustomerId=varchar("tpay_customer_id").bindTo { it.tPayCustomerId }
    val tcpNum=varchar("tcp_num").bindTo { it.tcpNum }
    val customerName=varchar("customer_name").bindTo { it.customerName }
    val merchantName=varchar("merchant_name").bindTo { it.merchantName }
    val terminalType=varchar("terminal_type").bindTo { it.terminalType }
    val billCategory=varchar("bill_category").bindTo { it.billCategory }
    val status=varchar("status").bindTo { it.status }
    val subStatus=varchar("sub_status").bindTo { it.subStatus }
    val failureReason=varchar("failure_reason").bindTo { it.failureReason }
    val totalCartAmount=varchar("total_cart_amount").bindTo { it.totalCartAmount }
    val totalCartFinalAmt=varchar("total_cart_final_amt").bindTo { it.totalCartFinalAmt }
    val totalTaxAmt=varchar("total_tax_amt").bindTo { it.totalTaxAmt }
    val storeCode=varchar("store_code").bindTo { it.storeCode }
    val prepaidAmt=varchar("prepaid_amt").bindTo { it.prepaidAmt }
    val typeOfRequest=varchar("type_of_request").bindTo { it.typeOfRequest }
    val callBackUrl=varchar("call_back_url").bindTo { it.callBackUrl }
    val timeout=varchar("timeout").bindTo { it.timeout }
    val timeRemaining=varchar("time_remaining").bindTo { it.timeRemaining }
    val tdlOrderTransactId=varchar("tdl_order_transact_id").bindTo { it.tdlOrderTransactId }
    val reversalId=varchar("reversal_id").bindTo { it.reversalId }
    val tataPayPwaUrl=varchar("tata_pay_pwa_url").bindTo { it.tataPayPwaUrl }
    val errorInfo=varchar("error_info").bindTo { it.errorInfo }
    val warningInfo=varchar("warning_info").bindTo { it.warningInfo }
    val statusInfo=varchar("status_info").bindTo { it.statusInfo }
    val createdByUser=varchar("created_by_user").bindTo { it.createdByUser }
    val createdByDate=varchar("created_by_date").bindTo { it.createdByDate }
    val modifiedByUser=varchar("modified_by_user").bindTo { it.modifiedByUser }
    val modifiedByDate=varchar("modified_by_date").bindTo { it.modifiedByDate }
}