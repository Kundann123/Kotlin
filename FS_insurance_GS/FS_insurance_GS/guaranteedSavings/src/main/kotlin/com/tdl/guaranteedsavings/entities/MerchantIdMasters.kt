package com.tdl.guaranteedsavings.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.varchar

interface MerchantIdMaster: Entity<MerchantIdMaster>{

    val id: String
    val insurerId: String
    val merchantId: String
    val merchantName: String
    val terminalId: String
    val activeFlag: String
    val createdByUser: String
    val createdByDate: String
    val modifiedByUser: String
    val modifiedByDate: String
}

object MerchantIdMasters : Table<MerchantIdMaster>("merchantId_master")
{
    val id = varchar("id").primaryKey().bindTo { it.id }
    val insurerId = varchar("insurer_id").bindTo { it.insurerId }
    val merchantId = varchar("merchant_id").bindTo { it.merchantId }
    val merchantName = varchar("merchant_name").bindTo { it.merchantName }
    val terminalId = varchar("terminal_id").bindTo { it.terminalId}
    val activeFlag = varchar("active_flag").bindTo { it.activeFlag }
    val createdByUser = varchar("created_by_user").bindTo { it.createdByUser }
    val createdByDate = varchar("created_by_date").bindTo { it.createdByDate }
    val modifiedByUser = varchar("modified_by_user").bindTo { it.modifiedByUser }
    val modifiedByDate = varchar("modified_by_date").bindTo { it.modifiedByDate }
}