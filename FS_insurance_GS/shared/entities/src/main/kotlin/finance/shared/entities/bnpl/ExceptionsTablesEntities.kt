package finance.shared.entities.bnpl

import finance.shared.entities.bnpl.schemas.*
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

class CustomerException(exceptionId: EntityID<String>) : Entity<String>(exceptionId) {
    companion object : EntityClass<String, CustomerException>(CustomerExceptions)

    var exceptionId by CustomerExceptions.exceptionId
    var customerHash by CustomerExceptions.customerHash
    var customerID by CustomerExceptions.customerID
    var exceptionType by CustomerExceptions.exceptionType
    var exceptionReason by CustomerExceptions.exceptionReason
    var status by CustomerExceptions.status
    var createdOn by CustomerExceptions.createdOn
    var createdBy by CustomerExceptions.createdBy
    var updatedOn by CustomerExceptions.updatedOn
    var updatedBy by CustomerExceptions.updatedBy
}

class MrchntException(exceptionId: EntityID<String>) : Entity<String>(exceptionId) {
    companion object : EntityClass<String, MrchntException>(MrchntExceptions)

    var exceptionId by MrchntExceptions.exceptionId
    var merchantId by MrchntExceptions.merchantId
    var exceptionType by MrchntExceptions.exceptionType
    var exceptionReason by MrchntExceptions.exceptionReason
    var status by MrchntExceptions.status
    var createdOn by MrchntExceptions.createdOn
    var createdBy by MrchntExceptions.createdBy
    var updatedOn by MrchntExceptions.updatedOn
    var updatedBy by MrchntExceptions.updatedBy
}

class StoreException(exceptionId: EntityID<String>) : Entity<String>(exceptionId) {
    companion object : EntityClass<String, StoreException>(StoreExceptions)

    var exceptionId by StoreExceptions.exceptionId
    var storeId by StoreExceptions.storeId
    var exceptionType by StoreExceptions.exceptionType
    var exceptionReason by StoreExceptions.exceptionReason
    var status by StoreExceptions.status
    var createdOn by StoreExceptions.createdOn
    var createdBy by StoreExceptions.createdBy
    var updatedOn by StoreExceptions.updatedOn
    var updatedBy by StoreExceptions.updatedBy
}

class SkuException(exceptionId: EntityID<String>) : Entity<String>(exceptionId) {
    companion object : EntityClass<String, SkuException>(SkuExceptions)

    var exceptionId by SkuExceptions.exceptionId
    var skuId by SkuExceptions.skuId
    var merchantId by SkuExceptions.merchantId
    var exceptionType by SkuExceptions.exceptionType
    var exceptionReason by SkuExceptions.exceptionReason
    var status by SkuExceptions.status
    var createdOn by SkuExceptions.createdOn
    var createdBy by SkuExceptions.createdBy
    var updatedOn by SkuExceptions.updatedOn
    var updatedBy by SkuExceptions.updatedBy
}

class VelocityException(exceptionId: EntityID<String>) : Entity<String>(exceptionId) {
    companion object : EntityClass<String, VelocityException>(VelocityExceptions)

    var exceptionId by VelocityExceptions.exceptionId
    var skuId by VelocityExceptions.skuId
    var timeGap by VelocityExceptions.timeGap
    var exceptionType by VelocityExceptions.exceptionType
    var exceptionReason by VelocityExceptions.exceptionReason
    var status by VelocityExceptions.status
    var createdOn by VelocityExceptions.createdOn
    var createdBy by VelocityExceptions.createdBy
    var updatedOn by VelocityExceptions.updatedOn
    var updatedBy by VelocityExceptions.updatedBy
}

class PinException(pinExceptionId: EntityID<String>) : Entity<String>(pinExceptionId) {
    companion object : EntityClass<String, PinException>(PinExceptions)

    val pinExceptionId by PinExceptions.pinExceptionId
    var pin by PinExceptions.pin
    var lenderId by PinExceptions.lenderId
    var status by PinExceptions.status
    var createdOn by PinExceptions.createdOn
    var createdBy by PinExceptions.createdBy
    var updatedOn by PinExceptions.updatedOn
    var updatedBy by PinExceptions.updatedBy
}

class QikEmiMerchant(merchantId: EntityID<String>) : Entity<String>(merchantId) {
    companion object : EntityClass<String, QikEmiMerchant>(QikEmiMerchants)

    val merchantId by QikEmiMerchants.merchantId
    var status by QikEmiMerchants.status
    var createdOn by QikEmiMerchants.createdOn
    var createdBy by QikEmiMerchants.createdBy
    var updatedOn by QikEmiMerchants.updatedOn
    var updatedBy by QikEmiMerchants.updatedBy
}
