package com.tdl.guaranteedsavings.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


interface CKYCSearchMaster : Entity<CKYCSearchMaster>
{
    val parentCompnay: String
    val ckycRequestId: String
    val transactionStatus: String
    val ckycUpdatedDate: String
    val ckycRequestDate: String
    val ckycName: String
    val ckycPhotoImageType: String
    val ckycPhotoBytes: String
    val transactionId: Int
    val ckycAge: Int
    val ckycAccType: String
    val applicationFormNo: String
    val ckycId: Int
    val ckycAvailable: String
    val ckycGenDate: String
    val ckycPhoto: String
    val ckycFatherName: String
    val ckycRemarks: String
    val requestId: String
    val requestStatus: String
}

object CKYCSearchMasters : Table<CKYCSearchMaster>("ckyc_search_master")
{
    val parentCompany = varchar("parent_company").bindTo { it.parentCompnay }
    val ckycRequestId = varchar("ckyc_request_id").bindTo { it.ckycRequestId }
    val transactionStatus = varchar("transaction_status").bindTo { it.transactionStatus }
    val ckycUpdatedDate = varchar("ckyc_updated_date").bindTo { it.ckycUpdatedDate }
    val ckycRequestDate = varchar("ckyc_request_date").bindTo { it.ckycRequestDate }
    val ckycName = varchar("ckyc_name").bindTo { it.ckycName }
    val ckycPhotoImageType = varchar("ckyc_photo_image_type").bindTo { it.ckycPhotoImageType }
    val ckycPhotoBytes = varchar("ckyc_photo_bytes").bindTo { it.ckycPhotoBytes }
    val transactionId = int("transaction_id").bindTo { it.transactionId }
    val ckycAge = int("ckyc_age").bindTo { it.ckycAge }
    val ckycAccType = varchar("ckyc_acc_type").bindTo { it.ckycAccType }
    val applicationFormNo = varchar("application_form_no").bindTo { it.applicationFormNo }
    val ckycId = int("ckyc_id").bindTo { it.ckycId }
    val ckycAvailable = varchar("ckyc_available").bindTo { it.ckycAvailable }
    val ckycGenDate = varchar("ckyc_gen_date").bindTo { it.ckycGenDate }
    val ckycPhoto = varchar("ckyc_photo").bindTo { it.ckycPhoto }
    val ckycFatherName = varchar("ckyc_father_name").bindTo { it.ckycFatherName }
    val ckycRemarks = varchar("ckyc_remarks").bindTo { it.ckycRemarks }
    val requestId = varchar("request_id").bindTo { it.requestId }
    val requestStatus = varchar("request_status").bindTo { it.requestStatus }

}
