package com.tdl.guaranteedsavings.di

import com.tdl.guaranteedsavings.repository.InsuredCustomerRepository
import com.tdl.guaranteedsavings.repository.InsurerMasterRepository
import com.tdl.guaranteedsavings.repository.PlanRepository
import com.tdl.guaranteedsavings.service.*
import com.tdl.guaranteedsavings.service.impl.*
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val kodein = DI {
    bind<CKYCService>() with singleton { CKYCServiceImpl() }
    bind<MerchantIdMasterService>() with singleton { MerchantIdMasterServiceImpl() }
    bind<InsurerMasterService>() with singleton { InsurerMasterServiceImpl() }
    bind<InsurerMasterRepository>() with singleton { InsurerMasterRepository() }
    bind<TataAIAService>() with singleton { TataAIAServiceImpl() }
    bind<InsuredCustomer>() with singleton { InsuredCustomerImpl() }
    bind<InsuredCustomerRepository>() with singleton { InsuredCustomerRepository() }
    bind<PlanService>() with singleton { PlanServiceImpl() }
    bind<PlanRepository>() with singleton { PlanRepository() }
    //bind<UserDetailsRepository>() with singleton { UserDetailsRepository() }
    bind<UserDetailsService>()with singleton { UserDetailsServiceImpl() }
}
