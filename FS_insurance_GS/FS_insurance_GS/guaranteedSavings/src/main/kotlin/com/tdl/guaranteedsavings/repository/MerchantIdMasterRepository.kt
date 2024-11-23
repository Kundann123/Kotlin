package com.tdl.guaranteedsavings.repository

import com.tdl.guaranteedsavings.entities.MerchantIdMasters
import com.tdl.guaranteedsavings.config.DBConfig
import com.tdl.guaranteedsavings.dto.MerchantIdMasterDTO
import org.ktorm.dsl.eq
import org.ktorm.dsl.insert
import org.ktorm.dsl.update

class MerchantIdMasterRepository {

    suspend fun saveMerchantIdMaster(merchantInfo: MerchantIdMasterDTO) {
        return DBConfig.dbQuery {
            DBConfig.getDatabase().insert(MerchantIdMasters) {
                set(it.id,merchantInfo.id)
                set(it.insurerId,merchantInfo.insurerId)
                set(it.merchantId, merchantInfo.merchantId)
                set(it.merchantName, merchantInfo.merchantName)
                set(it.terminalId, merchantInfo.terminalId)
                set(it.activeFlag, merchantInfo.activeFlag)
                set(it.createdByUser, merchantInfo.createdByUser)
                set(it.createdByDate,merchantInfo.createdByDate)
                set(it.modifiedByUser,merchantInfo.modifiedByUser)
                set(it.modifiedByDate,merchantInfo.modifiedByDate)
            }
        }
    }

    suspend fun updateMerchantIdMaster(merchantInfo: MerchantIdMasterDTO)
    {
        return DBConfig.dbQuery {
            DBConfig.getDatabase().update(MerchantIdMasters)
            {
                set(it.id,merchantInfo.id)
                set(it.insurerId,merchantInfo.insurerId)
                set(it.merchantId, merchantInfo.merchantId)
                set(it.merchantName, merchantInfo.merchantName)
                set(it.terminalId, merchantInfo.terminalId)
                set(it.activeFlag, merchantInfo.activeFlag)
                set(it.createdByUser, merchantInfo.createdByUser)
                set(it.createdByDate,merchantInfo.createdByDate)
                set(it.modifiedByUser,merchantInfo.modifiedByUser)
                set(it.modifiedByDate,merchantInfo.modifiedByDate)
                where { it.id eq merchantInfo.id }
            }

        }
    }
}