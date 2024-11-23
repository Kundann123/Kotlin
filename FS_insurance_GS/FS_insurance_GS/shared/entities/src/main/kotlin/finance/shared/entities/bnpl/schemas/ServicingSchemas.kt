package finance.shared.entities.bnpl.schemas


import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.javatime.date
import org.jetbrains.exposed.sql.javatime.datetime

object RefundDetails : IdTable<String>("refund_details") {

    val merchantId = varchar("merchant_id", 255)
    val merchantOrderId = varchar("merchant_order_id", 255)
    val transactionId = varchar("transaction_id", 255).nullable()
    val refundId = varchar("refund_id", 255)
    val refundAmount = double("refund_amount")
    val refundType = varchar("refund_type", 255).nullable()
    val terminalId = varchar("terminal_id", 255).nullable()
    val tpayCallbackUrl = varchar("tpay_callback_url", 255)
    val refundTransactionId = varchar("refund_transaction_id", 255).nullable()
    val status = varchar("status", 255)
    val actionPending = varchar("action_pending", 255).nullable()
    val refundedAt = datetime("refunded_at")
    val clRefundAmount = double("cl_refund_amount").nullable()
    val tpayRefundAmount = double("tpay_refund_amount").nullable()
    val instrumentType = varchar("instrument_type", 255)
    val error = varchar("error", 255).nullable()
    val createdBy = varchar("created_by", 255)
    val createdOn = datetime("created_on")
    val updatedBy = varchar("updated_by", 255)
    val updatedOn = datetime("updated_on")
    override val id: Column<EntityID<String>> = refundId.entityId()

}

object SubRefundDetails : IdTable<String>("sub_refund_details") {


    val subRefundId = varchar("sub_refund_id", 255)
    val subTransactionId = varchar("sub_transaction_id", 255)
    val refundId = reference("refund_id", RefundDetails)
    val lenderTransactionId = varchar("lender_transaction_id", 255).nullable()
    val refundAmount = double("refund_amount")
    val clRefundAmount = double("cl_refund_amount")
    val tpayRefundAmount = double("tpay_refund_amount")
    val status = varchar("status", 255)
    val createdBy = varchar("created_by", 255)
    val createdOn = datetime("created_on")
    val updatedBy = varchar("updated_by", 255)
    val updatedOn = datetime("updated_on")
    override val id: Column<EntityID<String>> = subRefundId.entityId()

}


object ProductRefunds : IdTable<String>("product_refund") {
    var ID = varchar("id",255)
    var skuId = varchar("sku_id", 255)
    var skuRefundAmount = double("sku_refund_amount")
    var quantity = integer("quantity")
    var imeiNumber = varchar("imei_number", 255).nullable()
    var serialNumber = varchar("serial_number", 255).nullable()
    val refundId = reference("refund_id", RefundDetails)
    val transactionId = varchar("transaction_id", 255).nullable()
    val subTransactionId = varchar("sub_transaction_id", 255).nullable()
    val createdBy = varchar("created_by", 255)
    val createdOn = datetime("created_on")
    val updatedBy = varchar("updated_by", 255)
    val updatedOn = datetime("updated_on")
    override val id: Column<EntityID<String>> = ID.entityId()
}


object OfflineRefundProducts : IdTable<String>("offline_refund_products") {


    var ID = varchar("id", 255)
    val refundId = reference("refund_id", RefundDetails)
    var skuId = varchar("sku_id", 255)
    var skuRefundAmount = double("sku_refund_amount")
    var refundDate = date("refund_date")
    var utrNumber = varchar("utr_number", 255).nullable()
    val createdBy = varchar("created_by", 255)
    val createdOn = datetime("created_on")
    override val id: Column<EntityID<String>> = ProductRefunds.ID.entityId()

}

