package com.tdl.guaranteedsavings.repository

import com.tdl.guaranteedsavings.config.DBConfig
import com.tdl.guaranteedsavings.dto.UserDetailsDTO
import com.tdl.guaranteedsavings.entities.UserDetailsEntities
import com.tdl.guaranteedsavings.entities.UserDetailsEntity
import org.ktorm.dsl.*

class UserDetailsRepository {

   private var database = DBConfig.getDatabase()

    suspend fun saveUserDetails(userDetails: UserDetailsDTO): Int {

        return DBConfig.dbQuery {
            println("data"+userDetails)
            database.insert(UserDetailsEntities) {
                set(it.custHash, userDetails.custHash)
                set(it.email, userDetails.email)
                set(it.panName, userDetails.panName)
                set(it.bankIfscCode, userDetails.bankIfscCode)
                set(it.bankName, userDetails.bankName)
                set(it.branchName, userDetails.branchName)
                set(it.typeOfAccount, userDetails.typeOfAccount)
                set(it.annualIncomeRange, userDetails.annualIncomeRange)
                set(it.relationshipWithNominee, userDetails.relationshipWithNominee)
                set(it.gender, userDetails.gender)
                set(it.nomineeFullName, userDetails.nomineeFullName)
                set(it.heightFts,userDetails.heightFts)
                set(it.heightInch,userDetails.heightInch)
                set(it.weightKgs,userDetails.weightKgs)
                set(it.createdByUser, userDetails.createdByUser)
                set(it.createdByDatetime,userDetails.createdByDatetime)
                set(it.modifiedByUser,userDetails.modifiedByUser)
                set(it.modifiedByDatetime,userDetails.modifiedByDatetime)


            }

        }

    }

    suspend fun updateUserDetails(userDetailsData: UserDetailsDTO): List<UserDetailsEntity>{
        return if(userDetailsData.custHash != null) {
            DBConfig.dbQuery {

                database.from(UserDetailsEntities).joinReferencesAndSelect()
                    .where { (userDetailsData.custHash!! eq UserDetailsEntities.custHash) }
                    .map { UserDetailsEntities.createEntity(it) }
            }

        } else {
            database.from(UserDetailsEntities).joinReferencesAndSelect()
                .map { UserDetailsEntities.createEntity(it) }
        }

    }

}




