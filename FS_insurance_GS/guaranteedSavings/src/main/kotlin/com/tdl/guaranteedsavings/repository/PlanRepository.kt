package com.tdl.guaranteedsavings.repository

import com.tdl.guaranteedsavings.config.DBConfig
import com.tdl.guaranteedsavings.dto.InsuranceDataRequest
import com.tdl.guaranteedsavings.dto.PlansDTO
import com.tdl.guaranteedsavings.entities.InsuranceApplication
import com.tdl.guaranteedsavings.entities.InsuranceApplications
import com.tdl.guaranteedsavings.entities.Plans
import org.ktorm.dsl.and
import org.ktorm.dsl.eq
import org.ktorm.dsl.from
import org.ktorm.dsl.insert
import org.ktorm.dsl.joinReferencesAndSelect
import org.ktorm.dsl.map
import org.ktorm.dsl.where

class PlanRepository {

    private var database = DBConfig.getDatabase()
    suspend fun savePlanDetails(planData: PlansDTO): Int {

        return DBConfig.dbQuery {
            database.insert(Plans) {
                set(it.planId, planData.planId)
                set(it.insurerId, planData.insurerId)
                set(it.planCode, planData.planCode)
                set(it.planName, planData.planName)
                set(it.productType, planData.productType)
                set(it.activeFlag, planData.activeFlag)
                set(it.createdByUser, planData.createdByUser)
                set(it.createdByDate, planData.createdByDate)
                set(it.modifiedByUser, planData.modifiedByUser)
                set(it.modifiedByDate, planData.modifiedByDate)

            }

        }

    }

    suspend fun getApplicationData(applicationData: InsuranceDataRequest): List<InsuranceApplication> {
        return if (applicationData.planId != null) {
            DBConfig.dbQuery {

                database.from(InsuranceApplications).joinReferencesAndSelect()
                    .where { (applicationData.planId!! eq InsuranceApplications.planId) and (applicationData.customerHash!! eq InsuranceApplications.custHash) }
                    .map { InsuranceApplications.createEntity(it) }
            }
        } else {
            database.from(InsuranceApplications).joinReferencesAndSelect()
                .map { InsuranceApplications.createEntity(it) }
        }

    }

}


