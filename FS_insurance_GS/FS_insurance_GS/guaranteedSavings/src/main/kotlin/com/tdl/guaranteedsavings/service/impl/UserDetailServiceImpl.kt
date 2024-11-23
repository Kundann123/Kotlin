package com.tdl.guaranteedsavings.service.impl

import com.tdl.guaranteedsavings.di.kodein
import com.tdl.guaranteedsavings.dto.GetUserDetailDTO
import com.tdl.guaranteedsavings.dto.UserDetailDTO
import com.tdl.guaranteedsavings.dto.validateUserDetails
import com.tdl.guaranteedsavings.exception.GSBadRequestException
import com.tdl.guaranteedsavings.repository.UserDetailRepository
import com.tdl.guaranteedsavings.route.BodyException
import com.tdl.guaranteedsavings.service.UserDetailService
import io.konform.validation.Invalid
import org.kodein.di.instance

class UserDetailServiceImpl : UserDetailService {
    private val userDetailRepository by kodein.instance<UserDetailRepository>()

    override suspend fun saveUserDetails(body: UserDetailDTO): Any {
        val validData = mutableListOf<BodyException>()
        val bool = validateUserDetails.validate(body)
        if (bool is Invalid) {
            bool.errors.map {
                validData.add(
                        BodyException(
                                it.dataPath.substring(1),
                                it.message
                        )
                )
            }
            throw GSBadRequestException(
                    validData.toString()
            )
        }
        return userDetailRepository.saveUserDetails(body)
    }

    override suspend fun getUserDetails(body: GetUserDetailDTO): Any {
        return userDetailRepository.getUserDetails(body)
    }
}