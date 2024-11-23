package com.tdl.guaranteedsavings.service

import com.tdl.guaranteedsavings.dto.UserDetailsDTO

interface UserDetailsService {
    suspend fun saveUserInfoWithInsurancePolicy(body:UserDetailsDTO): Any
}