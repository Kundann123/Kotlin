package com.tdl.guaranteedsavings.service.impl

import com.tdl.guaranteedsavings.dto.UserDetailsDTO
import com.tdl.guaranteedsavings.repository.UserDetailsRepository
import com.tdl.guaranteedsavings.service.UserDetailsService
import io.ktor.http.*

class UserDetailsServiceImpl: UserDetailsService {

    //private val userDetailsRepository by kodein.instance<UserDetailsRepository>()
    override suspend fun saveUserInfoWithInsurancePolicy(body: UserDetailsDTO): Any {
        val userDetailsRepository=UserDetailsRepository()
        return userDetailsRepository.saveUserDetails(body).let {
            if (it == 0) HttpStatusCode.NotModified
            else HttpStatusCode.OK
        }
    }
}
