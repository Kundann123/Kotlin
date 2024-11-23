package com.tdl.guaranteedsavings.service

import com.tdl.guaranteedsavings.dto.A50SearchInCkycResponse
import com.tdl.guaranteedsavings.dto.CkycSearchResponse
import com.tdl.guaranteedsavings.dto.DownloadCkycDTO
import com.tdl.guaranteedsavings.dto.Request

interface CKYCService {
    suspend fun downloadCKYC(body: DownloadCkycDTO): Any

    suspend fun searchCKYC(body: Request): Any

    suspend fun saveCKYCSearchResponse(body: CkycSearchResponse)


}
