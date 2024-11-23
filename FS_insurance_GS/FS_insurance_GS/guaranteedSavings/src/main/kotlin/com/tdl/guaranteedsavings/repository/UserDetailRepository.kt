package com.tdl.guaranteedsavings.repository

import com.tdl.guaranteedsavings.config.DBConfig
import com.tdl.guaranteedsavings.dto.GetUserDetailDTO
import com.tdl.guaranteedsavings.dto.UserDetailDTO
import com.tdl.guaranteedsavings.dto.UserDetailResponseDTO
import com.tdl.guaranteedsavings.entities.UserDetails
import org.ktorm.dsl.*

class UserDetailRepository {
    private val databaseConnection = DBConfig.getDatabase()

    suspend fun saveUserDetails(body: UserDetailDTO): Int {
        return DBConfig.dbQuery {
            databaseConnection.insert(UserDetails) {
                set(it.customerHash, body.customerHash)
                set(it.email, body.email)
                set(it.phoneNumber, body.phoneNumber)
                set(it.panName, body.panName)
                set(it.ifscCode, body.ifscCode)
                set(it.bankName, body.bankName)
                set(it.branchName, body.branchName)
                set(it.typeOfAccount, body.typeOfAccount)
                set(it.incomeRange, body.incomeRange)
                set(it.relationshipWithNominee, body.relationshipWithNominee)
                set(it.gender, body.gender)
                set(it.nomineesFullName, body.nomineesFullName)
                set(it.heightInFoot, body.heightInFoot)
                set(it.heightInInch, body.heightInInch)
                set(it.weightInKg, body.weightInKg)
                set(it.createdByUser, body.createdByUser)
                set(it.createdByDate, body.createdByDate)
                set(it.modifiedByUser, body.modifiedByUser)
                set(it.modifiedByDate, body.modifiedByDate)
            }
        }
    }

    suspend fun getUserDetails(body: GetUserDetailDTO): Any {
        val result = DBConfig.dbQuery {
            databaseConnection.from(UserDetails).select()
                .where { (body.phoneNumber eq UserDetails.phoneNumber) and (body.customerHash eq UserDetails.customerHash) }
                .map { UserDetails.createEntity(it) }.map {
                UserDetailResponseDTO(
                    it.email,
                    it.phoneNumber,
                    it.ifscCode,
                    it.bankName,
                    it.branchName,
                    it.typeOfAccount
                )
            }
        }
        return result
    }
}