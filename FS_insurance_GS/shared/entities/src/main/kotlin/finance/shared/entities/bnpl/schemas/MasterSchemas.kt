package finance.shared.entities.bnpl.schemas


import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.javatime.datetime

object ModelMasters : IdTable<String>("model_master") {
    var modelId = varchar("model_id", 255).uniqueIndex()
    var modelNo = varchar("model_no", 255)
    var oemCode = varchar("oem_code", 255)
    var prodCategory = varchar("prod_category", 255)
    var mrp = varchar("mrp", 255)
    var status = varchar("status", 255)
    var createdOn = datetime("created_on")
    var createdBy = varchar("created_by", 255)
    var updatedOn = datetime("updated_on")
    var updatedBy = varchar("updated_by", 255)
    override val id: Column<EntityID<String>> = modelId.entityId()
}

object SkuMasters : IdTable<String>("sku_master") {

    var skuId = varchar("sku_id", 255).uniqueIndex()
    val modelId = reference("model_id", ModelMasters)
    var status = varchar("status", 255)
    var createdOn = datetime("created_on")
    var createdBy = varchar("created_by", 255)
    var updatedOn = datetime("updated_on")
    var updatedBy = varchar("updated_by", 255)
    override val id: Column<EntityID<String>> = skuId.entityId()
}
object LenderMasters : IdTable<String>("lender_master") {
    var lenderId = varchar("lender_id", 255).uniqueIndex()
    var entityName = varchar("entity_name", 255)
    var lenderType = varchar("lender_type", 255)
    var lenderName = varchar("lender_name", 255).nullable()
    var kfsLinkText = varchar("kfs_link_text", 255).nullable()
    var kfsLinkUri = varchar("kfs_link_uri", 255).nullable()
    var kfsLinkDisplay = bool("kfs_link_display").nullable()
    var status = varchar("status", 255)
    var createdOn = datetime("created_on")
    var createdBy = varchar("created_by", 255)
    var updatedOn = datetime("updated_on")
    var updatedBy = varchar("updated_by", 255)
    override val id: Column<EntityID<String>> = lenderId.entityId()
}


object MerchantMasters : IdTable<String>("mrchnt_master") {
    var merchantId = varchar("merchant_id", 255).uniqueIndex()
    val entityName = varchar("entity_name", 255)
    val cityId = varchar("city_id", 255)
    val cityName = varchar("city_name", 255)
    val address = varchar("address", 255)
    val interestRate = double("interest_rate")
    var postPaidMin = integer("postpaid_min").nullable()
    var postPaidMax = integer("postpaid_max").nullable()
    var emiMin = integer("emi_min").nullable()
    var emiMax = integer("emi_max").nullable()
    val pin = varchar("pin", 255)
    var lenderId = reference("lender_id", LenderMasters)
    var lenderLrr = double("lender_lrr").nullable()
    val parentMerchantId = varchar("parent_merchant_id", 255).nullable()
    var status = varchar("status", 255)
    var createdOn = datetime("created_on")
    var createdBy = varchar("created_by", 255)
    var updatedOn = datetime("updated_on")
    var updatedBy = varchar("updated_by", 255)
    override val id: Column<EntityID<String>> = merchantId.entityId()
}

object SchmMpngMasters : IdTable<String>("schm_mpng_master") {
    var schmMpngId = varchar("schm_mpng_id", 255).uniqueIndex()
    var modelId = varchar("model_id", 255).nullable()
    var skuId = varchar("sku_id", 255).nullable()
    var lenderId = varchar("lender_id", 255).nullable()
    var merchantId = varchar("merchant_id", 255).nullable()
    var schmId = varchar("schm_id", 255)
    var status = varchar("status", 255)
    var createdOn = datetime("created_on")
    var createdBy = varchar("created_by", 255)
    var updatedOn = datetime("updated_on")
    var updatedBy = varchar("updated_by", 255)
    override val id: Column<EntityID<String>> = schmMpngId.entityId()
}

object SchmMasters : IdTable<String>("schm_master") {
    var schmId = varchar("schm_id", 255).uniqueIndex()
    var schmNo = varchar("schm_no", 255)
    var tenure = integer("tenure")
    var advanceEmi = double("advance_emi").nullable()
    var dbd = double("dbd").nullable()
    var gstDbd = double("gst_dbd").nullable()
    var mbd = double("mbd").nullable()
    var gstMbd = double("gst_mbd").nullable()
    var pf = double("pf").nullable()
    var gstPf = double("gst_pf").nullable()
    var convFee = double("conv_fee").nullable()
    var gstConvFee = double("gst_conv_fee").nullable()
    var anyOtherFee = double("any_other_fee").nullable()
    var gstAnyOth = double("gst_any_oth").nullable()
    var noCostEmi = bool("no_cost_emi")
    var status = varchar("status", 255)
    var createdOn = datetime("created_on")
    var createdBy = varchar("created_by", 255)
    var updatedOn = datetime("updated_on")
    var updatedBy = varchar("updated_by", 255)
    override val id: Column<EntityID<String>> = schmId.entityId()
}

object EmiInterestRatesMaster : IdTable<String>("emi_interest_rate_master") {
    var emiInterestRateId = varchar("emi_interest_rate_id", 255).uniqueIndex()
    var lenderId = reference("lender_id", LenderMasters)
    var merchantId = reference("merchant_id", MerchantMasters)
    var interestRate = double("interest_rate")
    var status = varchar("status", 255)
    var createdOn = datetime("created_on")
    var createdBy = varchar("created_by", 255)
    var updatedOn = datetime("updated_on")
    var updatedBy = varchar("updated_by", 255)
    var lenderDiscount = double("lender_discount").nullable()
    override val id: Column<EntityID<String>> = emiInterestRateId.entityId()
}

object TplConfigs : IdTable<String>("tpl_config") {
    var tplConfigId = varchar("tpl_config_id", 255).uniqueIndex()
    var cacheId = varchar("cache_id", 255)
    var cacheName = varchar("cache_name", 255)
    var refreshCache = bool("refresh_cache")
    var status = varchar("status", 255)
    var createdOn = datetime("created_on")
    var createdBy = varchar("created_by", 255)
    var updatedOn = datetime("updated_on")
    var updatedBy = varchar("updated_by", 255)
    override val id: Column<EntityID<String>> = tplConfigId.entityId()

}

