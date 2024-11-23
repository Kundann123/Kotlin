package com.tdl.guaranteedsavings.entities

import java.time.LocalDateTime
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.datetime
import org.ktorm.schema.varchar

interface Plan : Entity<Plan> {
    var planId: String
    var insurerId: String
    var planCode: String
    var planName: String
    var productType: String
    var activeFlag: String
    var createdByUser: String
    var createdByDate: LocalDateTime
    var modifiedByUser: String
    var modifiedByDate: LocalDateTime


}

 object Plans : Table<Plan>("plans") {
    var planId = varchar("plan_id").bindTo { it.planId }.primaryKey()
    var insurerId = varchar("insurar_id").bindTo { it.insurerId }
    var planCode = varchar("plan_code").bindTo { it.planCode }
    var planName = varchar("plan_name").bindTo { it.planName }
    var productType = varchar("product_type").bindTo { it.productType }
    var activeFlag = varchar("active_flag").bindTo { it.activeFlag }
    var createdByDate = datetime("created_by_date").bindTo { it.createdByDate }
    var modifiedByUser = varchar("modified_by_user").bindTo { it.modifiedByUser }
    var modifiedByDate = datetime("modified_by_date").bindTo { it.modifiedByDate }
    var createdByUser = varchar("created_by_user").bindTo { it.createdByUser }

}