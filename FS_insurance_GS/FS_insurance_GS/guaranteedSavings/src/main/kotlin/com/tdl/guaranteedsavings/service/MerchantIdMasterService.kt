package com.tdl.guaranteedsavings.service

import com.tdl.guaranteedsavings.dto.MerchantIdMasterDTO

interface MerchantIdMasterService {

suspend fun saveMerchantIdMaster(merchantInfo: MerchantIdMasterDTO)

suspend fun updateMerchantIdMaster(merchantInfo: MerchantIdMasterDTO)

}