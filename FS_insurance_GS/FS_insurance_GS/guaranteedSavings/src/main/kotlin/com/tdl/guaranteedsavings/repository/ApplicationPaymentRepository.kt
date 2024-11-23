package com.tdl.guaranteedsavings.repository

import com.tdl.guaranteedsavings.config.DBConfig
import com.tdl.guaranteedsavings.dto.ApplicationPaymentDTO
import com.tdl.guaranteedsavings.dto.ApplicationPaymentResponseDTO
import com.tdl.guaranteedsavings.dto.GetDetailsDTO
import com.tdl.guaranteedsavings.dto.UpdateDetailsDTO
import com.tdl.guaranteedsavings.entities.ApplicationPayments
import org.ktorm.dsl.*

class ApplicationPaymentRepository {
    private val databaseConnection = DBConfig.getDatabase()
    suspend fun saveDetails(body: ApplicationPaymentDTO): Int {
        return DBConfig.dbQuery {
            databaseConnection.insert(ApplicationPayments) {
                set(it.paymentId, body.paymentId)
                set(it.orderId, body.orderId)
                set(it.orderRetrialId, body.orderRetrialId)
                set(it.merchantId, body.merchantId)
                set(it.tPayCustomerId, body.tPayCustomerId)
                set(it.tcpNum, body.tcpNum)
                set(it.customerName, body.customerName)
                set(it.merchantName, body.merchantName)
                set(it.terminalType, body.terminalType)
                set(it.billCategory, body.billCategory)
                set(it.status, body.status)
                set(it.subStatus, body.subStatus)
                set(it.failureReason, body.failureReason)
                set(it.totalCartAmount, body.totalCartAmount)
                set(it.totalCartFinalAmt, body.totalCartFinalAmt)
                set(it.totalTaxAmt, body.totalTaxAmt)
                set(it.storeCode, body.storeCode)
                set(it.prepaidAmt, body.prepaidAmt)
                set(it.typeOfRequest, body.typeOfRequest)
                set(it.callBackUrl, body.callBackUrl)
                set(it.timeout, body.timeout)
                set(it.timeRemaining, body.timeRemaining)
                set(it.tdlOrderTransactId, body.tdlOrderTransactId)
                set(it.reversalId, body.reversalId)
                set(it.tataPayPwaUrl, body.tataPayPwaUrl)
                set(it.errorInfo, body.errorInfo)
                set(it.warningInfo, body.warningInfo)
                set(it.statusInfo, body.statusInfo)
                set(it.createdByUser, body.createdByUser)
                set(it.createdByDate, body.createdByDate)
                set(it.modifiedByUser, body.modifiedByUser)
                set(it.modifiedByDate, body.modifiedByDate)
            }.also { println(it) }
        }
    }


    suspend fun getDetails(body: GetDetailsDTO):Any {
        val result= DBConfig.dbQuery {
            databaseConnection.from(ApplicationPayments).select().where { body.paymentId eq ApplicationPayments.paymentId }.
            map {ApplicationPayments.createEntity(it) }.map {
                ApplicationPaymentResponseDTO(
                    it.tPayCustomerId,          //set to paymentId
                    it.tcpNum
                )
            }

        }
        return result
    }

//    suspend fun updateDetails(body: ApplicationPaymentDTO) {
//        return DBConfig.dbQuery {
//            databaseConnection.update(ApplicationPayments){
//                where {
//                    it.paymentId eq body.paymentId
//                }
//                set(it.paymentId, body.paymentId)
//                set(it.orderId, body.orderId)
//                set(it.orderRetrialId, body.orderRetrialId)
//                set(it.merchantId, body.merchantId)
//                set(it.tPayCustomerId, body.tPayCustomerId)
//                set(it.tcpNum, body.tcpNum)
//                set(it.customerName, body.customerName)
//                set(it.merchantName, body.merchantName)
//                set(it.terminalType, body.terminalType)
//                set(it.billCategory, body.billCategory)
//                set(it.status, body.status)
//                set(it.subStatus, body.subStatus)
//                set(it.failureReason, body.failureReason)
//                set(it.totalCartAmount, body.totalCartAmount)
//                set(it.totalCartFinalAmt, body.totalCartFinalAmt)
//                set(it.totalTaxAmt, body.totalTaxAmt)
//                set(it.storeCode, body.storeCode)
//                set(it.prepaidAmt, body.prepaidAmt)
//                set(it.typeOfRequest, body.typeOfRequest)
//                set(it.callBackUrl, body.callBackUrl)
//                set(it.timeout, body.timeout)
//                set(it.timeRemaining, body.timeRemaining)
//                set(it.tdlOrderTransactId, body.tdlOrderTransactId)
//                set(it.reversalId, body.reversalId)
//                set(it.tataPayPwaUrl, body.tataPayPwaUrl)
//                set(it.errorInfo, body.errorInfo)
//                set(it.warningInfo, body.warningInfo)
//                set(it.statusInfo, body.statusInfo)
//                set(it.createdByUser, body.createdByUser)
//                set(it.createdByDate, body.createdByDate)
//                set(it.modifiedByUser, body.modifiedByUser)
//                set(it.modifiedByDate, body.modifiedByDate)
//
//            }
//        }
//    }
suspend fun updateDetails(body: UpdateDetailsDTO) {
        return DBConfig.dbQuery {
            databaseConnection.update(ApplicationPayments){
                where {
                    it.paymentId eq body.targetId
                }
                set(it.customerName, body.updationField.customerName)
                set(it.status, body.updationField.status)
                set(it.totalCartFinalAmt, body.updationField.totalCartFinalAmt)
                set(it.totalTaxAmt, body.updationField.totalTaxAmt)
                set(it.modifiedByUser, body.updationField.modifiedByUser)
                set(it.modifiedByDate, body.updationField.modifiedByDate)
            }
        }
    }
}