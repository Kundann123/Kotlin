package com.tdl.guaranteedsavings.service

import com.tdl.guaranteedsavings.dto.InsurerMasterDTO

interface InsurerMasterService {
    fun saveInsurerWithInsurancePolicy(insurerInfo: InsurerMasterDTO): Any
}