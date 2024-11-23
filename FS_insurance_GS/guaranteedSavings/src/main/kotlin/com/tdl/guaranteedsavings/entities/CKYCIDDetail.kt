package com.tdl.guaranteedsavings.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


interface CKYCIDDetail : Entity<CKYCIDDetail>
{
    val ckycId: Int
    val ckycIdRemarks: String
    val ckycAvailableIdType: String
    val ckycAvailableIdTypeStatus: String
}

object CKYCIDDetails : Table<CKYCIDDetail>("ckyc_id_details")
{
    val ckycId = int("ckyc_id").bindTo { it.ckycId }
    val ckycIdRemarks = varchar("ckyc_id_remarks").bindTo { it.ckycIdRemarks }
    val ckycAvailableIdType = varchar("ckyc_available_id_type").bindTo { it.ckycAvailableIdType }
    val ckycAvailableIdTypeStatus = varchar("ckyc_available_id_type_status").bindTo { it.ckycAvailableIdTypeStatus }
}