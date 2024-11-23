package finance.shared.entities.bnpl.schemas

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.javatime.datetime

object CustomerExceptions : IdTable<String>("customer_exception") {
    val exceptionId = varchar("exception_id", 255)
    val customerHash = varchar("customer_hash", 255)
    val customerID = varchar("customer_id", 255).nullable()
    val exceptionType = varchar("exception_type", 255)
    val exceptionReason = varchar("exception_reason", 255)
    val status = varchar("status", 255)
    val createdOn = datetime("created_on")
    val createdBy = varchar("created_by", 255)
    val updatedOn = datetime("updated_on")
    val updatedBy = varchar("updated_by", 255)
    override val id: Column<EntityID<String>> = exceptionId.entityId()

}

object MrchntExceptions : IdTable<String>("mrchnt_exception") {
    val exceptionId = varchar("exception_id", 255)
    val merchantId = varchar("merchant_id", 255)
    val exceptionType = varchar("exception_type", 255)
    val exceptionReason = varchar("exception_reason", 255)
    val status = varchar("status", 255)
    val createdOn = datetime("created_on")
    val createdBy = varchar("created_by", 255)
    val updatedOn = datetime("updated_on")
    val updatedBy = varchar("updated_by", 255)

    override val id: Column<EntityID<String>> = exceptionId.entityId()
}

object StoreExceptions : IdTable<String>("store_exception") {
    val exceptionId = varchar("exception_id", 255)
    val storeId = varchar("store_id", 255)
    val exceptionType = varchar("exception_type", 255)
    val exceptionReason = varchar("exception_reason", 255)
    val status = varchar("status", 255)
    val createdOn = datetime("created_on")
    val createdBy = varchar("created_by", 255)
    val updatedOn = datetime("updated_on")
    val updatedBy = varchar("updated_by", 255)

    override val id: Column<EntityID<String>> = exceptionId.entityId()
}

object SkuExceptions : IdTable<String>("sku_exception") {
    val exceptionId = varchar("exception_id", 255)
    val skuId = varchar("sku_id", 255)
    val merchantId = varchar("merchant_id", 255).nullable()
    val exceptionType = varchar("exception_type", 255)
    val exceptionReason = varchar("exception_reason", 255)
    val status = varchar("status", 255)
    val createdOn = datetime("created_on")
    val createdBy = varchar("created_by", 255)
    val updatedOn = datetime("updated_on")
    val updatedBy = varchar("updated_by", 255)

    override val id: Column<EntityID<String>> = exceptionId.entityId()
}

object VelocityExceptions : IdTable<String>("velocity_exception") {
    val exceptionId = varchar("exception_id", 255)
    val skuId = varchar("sku_id", 255)
    val timeGap = integer("time_gap")
    val exceptionType = varchar("exception_type", 255)
    val exceptionReason = varchar("exception_reason", 255)
    val status = varchar("status", 255)
    val createdOn = datetime("created_on")
    val createdBy = varchar("created_by", 255)
    val updatedOn = datetime("updated_on")
    val updatedBy = varchar("updated_by", 255)

    override val id: Column<EntityID<String>> = exceptionId.entityId()
}

object PinExceptions : IdTable<String>("pin_exception") {
    val pinExceptionId = varchar("pin_exception_id", 255).uniqueIndex()
    val pin = integer("pin").nullable()
    val lenderId = varchar("lender_id", 255)
    val status = varchar("status", 255)
    val createdOn = datetime("created_on")
    val createdBy = varchar("created_by", 255)
    val updatedOn = datetime("updated_on")
    val updatedBy = varchar("updated_by", 255)
    override val id: Column<EntityID<String>> = pinExceptionId.entityId()
}

object QikEmiMerchants : IdTable<String>("qik_emi_merchants") {
    val merchantId = varchar("merchant_id", 255).uniqueIndex()
    val status = varchar("status", 255)
    val createdOn = datetime("created_on")
    val createdBy = varchar("created_by", 255)
    val updatedOn = datetime("updated_on")
    val updatedBy = varchar("updated_by", 255)
    override val id: Column<EntityID<String>> = merchantId.entityId()
}