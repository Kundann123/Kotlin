package finance.shared.entities.bnpl

import finance.shared.entities.bnpl.schemas.*
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID


class ModelMaster(modelId: EntityID<String>) : Entity<String>(modelId) {
    companion object : EntityClass<String, ModelMaster>(ModelMasters)

    var modelId by ModelMasters.modelId
    var modelNo by ModelMasters.modelNo
    var oemCode by ModelMasters.oemCode
    var prodCategory by ModelMasters.prodCategory
    var mrp by ModelMasters.mrp
    var status by ModelMasters.status
    var createdOn by ModelMasters.createdOn
    var updatedOn by ModelMasters.updatedOn
    var createdBy by ModelMasters.createdBy
    var updatedBy by ModelMasters.updatedBy
}

class SkuMaster(skuId: EntityID<String>) : Entity<String>(skuId) {
    companion object : EntityClass<String, SkuMaster>(SkuMasters)

    var skuId by SkuMasters.skuId
    var modelId by ModelMaster referencedOn SkuMasters.modelId
    var status by SkuMasters.status
    var createdOn by SkuMasters.createdOn
    var updatedOn by SkuMasters.updatedOn
    var createdBy by SkuMasters.createdBy
    var updatedBy by SkuMasters.updatedBy
}

class MerchantMaster(merchantId: EntityID<String>) : Entity<String>(merchantId) {
    companion object : EntityClass<String, MerchantMaster>(MerchantMasters)

    var merchantId by MerchantMasters.merchantId
    var lenderId by LenderMaster referencedOn MerchantMasters.lenderId

    var entityName by MerchantMasters.entityName
    var cityId by MerchantMasters.cityId

    var cityName by MerchantMasters.cityName
    var address by MerchantMasters.address
    var interestRate by MerchantMasters.interestRate
    var pin by MerchantMasters.pin
    var parentMerchantId by MerchantMasters.parentMerchantId
    var postPaidMin by MerchantMasters.postPaidMin
    var postPaidMax by MerchantMasters.postPaidMax
    var emiMin by MerchantMasters.emiMin
    var emiMax by MerchantMasters.emiMax

    var status by MerchantMasters.status
    var createdOn by MerchantMasters.createdOn
    var updatedOn by MerchantMasters.updatedOn
    var createdBy by MerchantMasters.createdBy
    var updatedBy by MerchantMasters.updatedBy
}


class LenderMaster(lenderId: EntityID<String>) : Entity<String>(lenderId) {
    companion object : EntityClass<String, LenderMaster>(LenderMasters)

    var lenderId by LenderMasters.lenderId
    var entityName by LenderMasters.entityName
    var lenderType by LenderMasters.lenderType
    var lenderName by LenderMasters.lenderName
    var kfsLinkText by LenderMasters.kfsLinkText
    var kfsLinkUri by LenderMasters.kfsLinkUri
    var kfsLinkDisplay by LenderMasters.kfsLinkDisplay
    var status by LenderMasters.status
    var createdOn by LenderMasters.createdOn
    var updatedOn by LenderMasters.updatedOn
    var createdBy by LenderMasters.createdBy
    var updatedBy by LenderMasters.updatedBy
}

class SchmMpngMaster(lenderId: EntityID<String>) : Entity<String>(lenderId) {
    companion object : EntityClass<String, SchmMpngMaster>(SchmMpngMasters)

    var schmMpngId by SchmMpngMasters.schmMpngId
    var modelId by SchmMpngMasters.modelId
    var skuId by SchmMpngMasters.skuId
    var lenderId by SchmMpngMasters.lenderId
    var merchantId by SchmMpngMasters.merchantId
    var schmId by SchmMpngMasters.schmId
    var status by SchmMpngMasters.status
    var createdOn by SchmMpngMasters.createdOn
    var updatedOn by SchmMpngMasters.updatedOn
    var createdBy by SchmMpngMasters.createdBy
    var updatedBy by SchmMpngMasters.updatedBy
}

class SchmMaster(lenderId: EntityID<String>) : Entity<String>(lenderId) {
    companion object : EntityClass<String, SchmMaster>(SchmMasters)

    var schmId by SchmMasters.schmId
    var schmNo by SchmMasters.schmNo
    var tenure by SchmMasters.tenure
    var advanceEmi by SchmMasters.advanceEmi
    var dbd by SchmMasters.dbd
    var gstDbd by SchmMasters.gstDbd
    var mbd by SchmMasters.mbd
    var gstMbd by SchmMasters.gstMbd
    var pf by SchmMasters.pf
    var gstPf by SchmMasters.gstPf
    var convFee by SchmMasters.convFee
    var gstConvFee by SchmMasters.gstConvFee
    var anyOtherFee by SchmMasters.anyOtherFee
    var gstAnyOth by SchmMasters.gstAnyOth
    var noCostEmi by SchmMasters.noCostEmi
    var status by SchmMasters.status
    var createdOn by SchmMasters.createdOn
    var updatedOn by SchmMasters.updatedOn
    var createdBy by SchmMasters.createdBy
    var updatedBy by SchmMasters.updatedBy
}

class EmiInterestRateMaster(emiInterestRateId: EntityID<String>) : Entity<String>(emiInterestRateId) {
    companion object : EntityClass<String, EmiInterestRateMaster>(EmiInterestRatesMaster)

    var emiInterestRateId by EmiInterestRatesMaster.emiInterestRateId
    var lenderId by LenderMaster referencedOn EmiInterestRatesMaster.lenderId
    var merchantId by MerchantMaster referencedOn EmiInterestRatesMaster.merchantId
    var interestRate by EmiInterestRatesMaster.interestRate
    var status by EmiInterestRatesMaster.status
    var createdOn by EmiInterestRatesMaster.createdOn
    var updatedOn by EmiInterestRatesMaster.updatedOn
    var createdBy by EmiInterestRatesMaster.createdBy
    var updatedBy by EmiInterestRatesMaster.updatedBy
    var lenderDiscount by EmiInterestRatesMaster.lenderDiscount
}

class TplConfig(tplConfigId: EntityID<String>) : Entity<String>(tplConfigId) {
    companion object : EntityClass<String, TplConfig>(TplConfigs)

    var tplConfigId by TplConfigs.tplConfigId
    var cacheId by TplConfigs.cacheId
    var cacheName by TplConfigs.cacheName
    var refreshCache by TplConfigs.refreshCache
    var status by TplConfigs.status
    var createdOn by TplConfigs.createdOn
    var updatedOn by TplConfigs.updatedOn
    var createdBy by TplConfigs.createdBy
    var updatedBy by TplConfigs.updatedBy

}