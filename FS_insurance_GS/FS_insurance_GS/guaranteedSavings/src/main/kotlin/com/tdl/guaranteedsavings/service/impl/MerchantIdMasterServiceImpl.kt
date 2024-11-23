package com.tdl.guaranteedsavings.service.impl

import com.tdl.guaranteedsavings.dto.MerchantIdMasterDTO
import com.tdl.guaranteedsavings.repository.MerchantIdMasterRepository
import com.tdl.guaranteedsavings.service.MerchantIdMasterService

class MerchantIdMasterServiceImpl: MerchantIdMasterService {
    private val merchantIdMasterRespository = MerchantIdMasterRepository()

    override suspend fun saveMerchantIdMaster(merchantInfo: MerchantIdMasterDTO) {
        return merchantIdMasterRespository.saveMerchantIdMaster(merchantInfo)

    }

    override suspend fun updateMerchantIdMaster(merchantInfo: MerchantIdMasterDTO) {
        return merchantIdMasterRespository.updateMerchantIdMaster(merchantInfo)
    }


}