package com.tdl.guaranteedsavings.service

import com.tdl.guaranteedsavings.dto.GetInfoResponseDTO
import com.tdl.guaranteedsavings.dto.PolicyGenerateDTOMOCK
import io.ktor.client.statement.*

interface PolicyGeneratorService {
    suspend fun generatePolicyNumber(body : PolicyGenerateDTOMOCK) : Any

    suspend fun getInformation(): Any
}