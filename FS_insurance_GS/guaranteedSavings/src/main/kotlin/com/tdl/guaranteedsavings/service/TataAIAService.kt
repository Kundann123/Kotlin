package com.tdl.guaranteedsavings.service

import com.tdl.guaranteedsavings.dto.PolicyGenerateDTO
import com.tdl.guaranteedsavings.dto.ValidateDocumentDTO

interface TataAIAService {

    suspend fun policyGenerate(body: PolicyGenerateDTO): Any

    suspend fun validateDocument(body: ValidateDocumentDTO): Any
}