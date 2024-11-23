package com.tdl.guaranteedsavings.service

import com.tdl.guaranteedsavings.dto.GetUserDetailDTO
import com.tdl.guaranteedsavings.dto.UserDetailDTO

interface UserDetailService {
    suspend fun saveUserDetails(body: UserDetailDTO):Any

    suspend fun getUserDetails(body: GetUserDetailDTO): Any
}