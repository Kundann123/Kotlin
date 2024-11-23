package com.tdl.guaranteedsavings.repository

import com.tdl.guaranteedsavings.entities.CKYCIDDetails
import com.tdl.guaranteedsavings.entities.CKYCSearchMasters
import com.tdl.guaranteedsavings.config.DBConfig
import com.tdl.guaranteedsavings.dto.CkycSearchResponse
import org.ktorm.dsl.insert


class CKYCRepository {

    suspend fun saveCKYCSearchDetails(body: CkycSearchResponse) {
        return DBConfig.dbQuery {
            DBConfig.getDatabase().insert(CKYCSearchMasters) {
                set(it.parentCompany, body.a50SearchInCkycResponse.parentCompany)
                set(it.ckycRequestId, body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.ckycRequestId)
                set(
                    it.transactionStatus,
                    body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.transactionStatus
                )
                set(
                    it.ckycUpdatedDate,
                    body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.ckycUpdatedDate
                )
                set(
                    it.ckycRequestDate,
                    body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.ckycRequestDate
                )
                set(it.ckycName, body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.ckycName)
                set(
                    it.ckycPhotoImageType,
                    body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.ckycPhotoImageType
                )
                set(it.ckycPhotoBytes, body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.ckycPhotoBytes)
                set(it.transactionId, body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.transactionId)
                set(it.ckycAge, body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.ckycAge)
                set(it.ckycAccType, body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.ckycAccType)
                set(
                    it.applicationFormNo,
                    body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.applicationFormNo
                )
                set(it.ckycId, body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.ckycId.hashCode())
                set(it.ckycAvailable, body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.ckycAvailable)
                set(it.ckycGenDate, body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.ckycGenDate)
                set(it.ckycPhoto, body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.ckycPhoto)
                set(it.ckycFatherName, body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.ckycFatherName)
                set(it.ckycRemarks, body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.ckycRemarks)
                set(it.requestId, body.a50SearchInCkycResponse.requestId)
                set(it.requestStatus, body.a50SearchInCkycResponse.requestStatus)
            }
            val objects=body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.ckycIdDetails.id
            objects.map {
                val idObject=it
                DBConfig.getDatabase().insert(CKYCIDDetails){
                    set(it.ckycId, body.a50SearchInCkycResponse.details.searchInCkycResponseDetails.ckycId.hashCode())
                    set(it.ckycIdRemarks,idObject.ckycIdRemarks)
                    set(it.ckycAvailableIdType,idObject.ckycAvailableIdType)
                    set(it.ckycAvailableIdTypeStatus,idObject.ckycAvailableIdTypeStatus)
                }
            }

        }
    }
}