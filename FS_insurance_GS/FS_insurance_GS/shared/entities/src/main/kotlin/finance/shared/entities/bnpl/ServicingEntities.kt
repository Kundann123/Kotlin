package finance.shared.entities.bnpl

import finance.shared.entities.bnpl.schemas.*
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID


class Refund(refundId: EntityID<String>) : Entity<String>(refundId) {
    companion object : EntityClass<String, Refund>(RefundDetails)


    var merchantId by RefundDetails.merchantId
    var merchantOrderId by RefundDetails.merchantOrderId
    var transactionId by RefundDetails.transactionId
    var refundId by RefundDetails.refundId
    var refundAmount by RefundDetails.refundAmount
    var refundType by RefundDetails.refundType
    var terminalId by RefundDetails.terminalId
    var tpayCallbackUrl by RefundDetails.tpayCallbackUrl
    var refundTransactionId by RefundDetails.refundTransactionId
    var status by RefundDetails.status
    var actionPending by RefundDetails.actionPending
    var refundedAt by RefundDetails.refundedAt
    var clRefundAmount by RefundDetails.clRefundAmount
    var tpayRefundAmount by RefundDetails.tpayRefundAmount
    var instrumentType by RefundDetails.instrumentType
    var error by RefundDetails.error
    var createdBy by RefundDetails.createdBy
    var createdOn by RefundDetails.createdOn
    var updatedBy by RefundDetails.updatedBy
    var updatedOn by RefundDetails.updatedOn
    // val subRefunds by SubRefund referrersOn SubRefundDetails.refundId
    // val productRefunds by ProductRefund referrersOn finance.shared.entities.schemas.ProductRefunds.refundId
    //val offlineRefundProducts by OfflineRefundProduct referrersOn finance.shared.entities.schemas.OfflineRefundProducts.refundId
}

class SubRefund(subRefundId: EntityID<String>) : Entity<String>(subRefundId) {
    companion object : EntityClass<String, SubRefund>(SubRefundDetails)


    var subRefundId by SubRefundDetails.subRefundId
    var subTransactionId by SubRefundDetails.subTransactionId
    var refundId by Refund referencedOn SubRefundDetails.refundId
    var lenderTransactionId by SubRefundDetails.lenderTransactionId
    var refundAmount by SubRefundDetails.refundAmount
    var clRefundAmount by SubRefundDetails.clRefundAmount
    var tpayRefundAmount by SubRefundDetails.tpayRefundAmount
    var status by SubRefundDetails.status
    var createdBy by SubRefundDetails.createdBy
    var createdOn by SubRefundDetails.createdOn
    var updatedBy by SubRefundDetails.updatedBy
    var updatedOn by SubRefundDetails.updatedOn
}

class ProductRefund(id: EntityID<String>) : Entity<String>(id) {
    companion object : EntityClass<String, ProductRefund>(ProductRefunds)


    var ID by ProductRefunds.ID
    var skuId by ProductRefunds.skuId
    var skuRefundAmount by ProductRefunds.skuRefundAmount
    var quantity by ProductRefunds.quantity
    var imeiNumber by ProductRefunds.imeiNumber
    var serialNumber by ProductRefunds.serialNumber
    var refundId by Refund referencedOn ProductRefunds.refundId
    var transactionId by ProductRefunds.transactionId
    var subTransactionId by ProductRefunds.subTransactionId
    var createdBy by ProductRefunds.createdBy
    var createdOn by ProductRefunds.createdOn
    var updatedBy by ProductRefunds.updatedBy
    var updatedOn by ProductRefunds.updatedOn

}

class OfflineRefundProduct(id: EntityID<String>) : Entity<String>(id) {
    companion object : EntityClass<String, OfflineRefundProduct>(OfflineRefundProducts)

    var ID by OfflineRefundProducts.ID
    var refundId by Refund referencedOn OfflineRefundProducts.refundId
    var skuId by OfflineRefundProducts.skuId
    var skuRefundAmount by OfflineRefundProducts.skuRefundAmount
    var refundDate by OfflineRefundProducts.refundDate
    var utrNumber by OfflineRefundProducts.utrNumber
    var createdBy by OfflineRefundProducts.createdBy
    var createdOn by OfflineRefundProducts.createdOn
}