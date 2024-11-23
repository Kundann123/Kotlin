package finance.shared.entities.plMarketplace

import finance.shared.entities.plMarketplace.schemas.*
import finance.shared.entities.plMarketplace.schemas.CustomerConsentSchema.autoIncrement
import finance.shared.entities.plMarketplace.schemas.CustomerConsentSchema.nullable
import finance.shared.entities.plMarketplace.schemas.CustomerConsentSchema.uniqueIndex
import finance.shared.entities.plMarketplace.schemas.PLMCustomerInfoSchema.entityId
import finance.shared.entities.plMarketplace.schemas.PLMCustomerInfoSchema.nullable
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.javatime.datetime

class QikPlCustomerInfoEntities(customerhash: EntityID<String>) : Entity<String>(customerhash){
    companion object : EntityClass<String, QikPlCustomerInfoEntities>(QikPlCustomerInfoSchema)

    var customerhash by QikPlCustomerInfoSchema.customerhash
    var address by QikPlCustomerInfoSchema.address
    var adharuploaded by QikPlCustomerInfoSchema.adharUploaded
    var approvaltype by QikPlCustomerInfoSchema.approvaltype
    var approvedamount by QikPlCustomerInfoSchema.approvedAmount
    var createdat by QikPlCustomerInfoSchema.createdAt
    var deviceid by QikPlCustomerInfoSchema.deviceId
    var dob by QikPlCustomerInfoSchema.dob
    var eamiladdress by QikPlCustomerInfoSchema.eamilAddress
    var employmenttyp by QikPlCustomerInfoSchema.employmenttyp
    var gender by QikPlCustomerInfoSchema.gender
    var geoaddress by QikPlCustomerInfoSchema.geoAddress
    var isgrprofileupdated by QikPlCustomerInfoSchema.isgrprofileupdated
    var istncchecked by QikPlCustomerInfoSchema.istncchecked
    var kycreq by QikPlCustomerInfoSchema.kycreq
    var kycthrough by QikPlCustomerInfoSchema.kycThrough
    var lastupdatedtimestamp by QikPlCustomerInfoSchema.lastupdatedtimestamp
    var mandatereq by QikPlCustomerInfoSchema.mandateReq
    var mobileno by QikPlCustomerInfoSchema.mobileno
    var name by QikPlCustomerInfoSchema.name
    var pan by QikPlCustomerInfoSchema.pan
    var pincode by QikPlCustomerInfoSchema.pincode
    var platfrom by QikPlCustomerInfoSchema.platfrom
    var preapprovedamount by QikPlCustomerInfoSchema.preapprovedamount
    var tnctimestamp by QikPlCustomerInfoSchema.tnctimestamp
    var tncversion by QikPlCustomerInfoSchema.tncversion
    var utmcampaign by QikPlCustomerInfoSchema.utmcampaign
    var utmcontent by QikPlCustomerInfoSchema.utmcontent
    var utmmedium by QikPlCustomerInfoSchema.utmmedium
    var utmpostonboaringreturnurl by QikPlCustomerInfoSchema.utmpostonboaringreturnurl
    var utmsource by QikPlCustomerInfoSchema.utmsource
    var utmtern by QikPlCustomerInfoSchema.utmterm
    var companyName by QikPlCustomerInfoSchema.companyName
    var companybasecotegary by QikPlCustomerInfoSchema.companybasecotegary
    var companyCotegary by QikPlCustomerInfoSchema.companyCotegary
    var companyCode by QikPlCustomerInfoSchema.companyCode
    var companyCodeBancs by QikPlCustomerInfoSchema.companyCodeBancs
    var companyemailId by QikPlCustomerInfoSchema.companyemailId
    var companyfinnone by QikPlCustomerInfoSchema.companyfinnone
    var comapanyGruop by QikPlCustomerInfoSchema.comapanyGruop
    var nscore by QikPlCustomerInfoSchema.nscore
    var emicardpreapprovedflag by QikPlCustomerInfoSchema.emicardpreapprovedflag
    var plpreapprovedamount by QikPlCustomerInfoSchema.plpreapprovedamount
    var plpreapprovedflag by QikPlCustomerInfoSchema.plpreapprovedflag
    var plleadid by QikPlCustomerInfoSchema.plleadid
    var plmaxtenure by QikPlCustomerInfoSchema.plmaxtenure
    var plopportunityid by QikPlCustomerInfoSchema.plopportunityid
    var plwebtopid by QikPlCustomerInfoSchema.plwebtopid
    var contractNumber by QikPlCustomerInfoSchema.contractNumber
    var plApprovalType by QikPlCustomerInfoSchema.plApprovalType
    var rejectionReason by QikPlCustomerInfoSchema.rejectionReason
    var leadId by QikPlCustomerInfoSchema.leadId
    var webtopId by QikPlCustomerInfoSchema.webtopId
    var plApprovedAmount by QikPlCustomerInfoSchema.plApprovedAmount
    var plkycRequired by QikPlCustomerInfoSchema.plkycRequired
    var plMandateRequired by QikPlCustomerInfoSchema.plMandateRequired
    var campaignType by QikPlCustomerInfoSchema.campaignType
    var userType by QikPlCustomerInfoSchema.userType
    var ipAddress by QikPlCustomerInfoSchema.ipAddress
    var offerType by QikPlCustomerInfoSchema.offerType
    var offercreatedate by QikPlCustomerInfoSchema.offercreatedate
    var offerExpiryDate by QikPlCustomerInfoSchema.offerExpiryDate
    var isvalidated by QikPlCustomerInfoSchema.isvalidated
    var validationTimestamp by QikPlCustomerInfoSchema.validationTimestamp
    var dobMatchFailedCount by QikPlCustomerInfoSchema.dobMatchFailedCount
    var invalidPanUsedCount by QikPlCustomerInfoSchema.invalidPanUsedCount
    var isTataEmployee by QikPlCustomerInfoSchema.isTataEmployee
    var nameMatchScore by QikPlCustomerInfoSchema.nameMatchScore
    var nameAsPerPan by QikPlCustomerInfoSchema.nameAsPerPan
    var idv_band by QikPlCustomerInfoSchema.idv_band
    var kycStatus by QikPlCustomerInfoSchema.kycStatus
    var nachStatus by QikPlCustomerInfoSchema.nachStatus
    var finBoxSource by QikPlCustomerInfoSchema.finBoxSource
}

class PLMCustomerInfoEntities(customerInfoId: EntityID<String>) : Entity<String>(customerInfoId) {
    companion object : EntityClass<String, PLMCustomerInfoEntities>(PLMCustomerInfoSchema)

    var dataHash by PLMCustomerInfoSchema.dataHash
    var pan by PLMCustomerInfoSchema.pan
    var dob by PLMCustomerInfoSchema.dob
    var firstName by PLMCustomerInfoSchema.firstName
    var middleName by PLMCustomerInfoSchema.middleName
    var lastName by PLMCustomerInfoSchema.lastName
    var gender by PLMCustomerInfoSchema.gender
    var pin by PLMCustomerInfoSchema.pin
    var email by PLMCustomerInfoSchema.email
    var occupation by PLMCustomerInfoSchema.occupation
    var monthlySalary by PLMCustomerInfoSchema.monthlySalary
    var purpose by PLMCustomerInfoSchema.purpose
    var companyCode by PLMCustomerInfoSchema.companyCode
    var deviceId by PLMCustomerInfoSchema.deviceId
    var platform by PLMCustomerInfoSchema.platform
    var customerInfoId by PLMCustomerInfoSchema.customerInfoId
    var partnerCustomerId by PLMCustomerInfoSchema.partnerCustomerId
    var mobile by PLMCustomerInfoSchema.mobile
    var customerHash by PLMCustomerInfoSchema.customerHash
    var status by PLMCustomerInfoSchema.status
    var createdOn by PLMCustomerInfoSchema.createdOn
    var createdBy by PLMCustomerInfoSchema.createdBy
    var updatedOn by PLMCustomerInfoSchema.updatedOn
    var updatedBy by PLMCustomerInfoSchema.updatedBy
    var companyEmail by PLMCustomerInfoSchema.companyEmail
    var nameAsPerPan by PLMCustomerInfoSchema.nameAsPerPan
    var finBoxEligibilityStatus by PLMCustomerInfoSchema.finBoxEligibilityStatus
    var rejectionReason by PLMCustomerInfoSchema.rejectionReason
    var consentData by PLMCustomerInfoSchema.consentData
    var companyName by PLMCustomerInfoSchema.companyName
    var companyCategory by PLMCustomerInfoSchema.companyCategory
}

class PlOffersEntities(transactionId: EntityID<String>) : Entity<String>(transactionId) {
    companion object : EntityClass<String, PlOffersEntities>(PlOffersSchema)
    var transactionId by PlOffersSchema.transactionId
    var plOfferId by PlOffersSchema.plOfferId
    var lenderId by PlOffersSchema.lenderId
    var type by PlOffersSchema.type
    var customerHash by PlOffersSchema.customerHash
    var offerAmount by PlOffersSchema.offerAmount
    var tenure by PlOffersSchema.tenure
    var rateOfInterest by PlOffersSchema.rateOfInterest
    var status by PlOffersSchema.status
    var tenureType by PlOffersSchema.tenureType
    var memberReferenceId by PlOffersSchema.memberReferenceId
    var dob by PlOffersSchema.dob
    var lenderName by PlOffersSchema.lenderName
    var limitType by PlOffersSchema.limitType
    var offerType by PlOffersSchema.offerType
    var sanctionedAmount by PlOffersSchema.sanctionedAmount
    var validFrom by PlOffersSchema.validFrom
    var validTill by PlOffersSchema.validTill
    var graceDaysAfterApplication by PlOffersSchema.graceDaysAfterApplication
    var createdOn by PlOffersSchema.createdOn
    var createdBy by PlOffersSchema.createdBy
    var updatedOn by PlOffersSchema.updatedOn
    var updatedBy by PlOffersSchema.updatedBy
}

class PlApplicationEventEntities(plApplicationEventId: EntityID<String>) : Entity<String>(plApplicationEventId) {
    companion object : EntityClass<String, PlApplicationEventEntities>(PlApplicationEventSchema)
    var plApplicationEventId by PlApplicationEventSchema.plApplicationEventId
    var partnerCustomerId by PlApplicationEventSchema.partnerCustomerId
    var eventType by PlApplicationEventSchema.eventType
    var partnerLoanApplicationId by PlApplicationEventSchema.partnerLoanApplicationId
    var eventSource by PlApplicationEventSchema.eventSource
    var journeyType by PlApplicationEventSchema.journeyType
    var status by PlApplicationEventSchema.status
    var event_descr by PlApplicationEventSchema.event_descr
    var entityType by PlApplicationEventSchema.entityType
    var createdOn by PlApplicationEventSchema.createdOn
    var createdBy by PlApplicationEventSchema.createdBy
    var updatedOn by PlApplicationEventSchema.updatedOn
    var updatedBy by PlApplicationEventSchema.updatedBy
}

class QikPlAvailed(plAvailedId: EntityID<Long>) : Entity<Long>(plAvailedId) {
    companion object : EntityClass<Long, QikPlAvailed>(QikPlAvailedSchema)

    var plAvailedId by QikPlAvailedSchema.plAvailedId
    var brokenPeriodDays by QikPlAvailedSchema.brokenPeriodDays
    var brokenPeriodInterest by QikPlAvailedSchema.brokenPeriodInterest
    var customerHash by QikPlAvailedSchema.customerHash
    var deductionExtra1 by QikPlAvailedSchema.deductionExtra1
    var deductionExtra2 by QikPlAvailedSchema.deductionExtra2
    var deviceId by QikPlAvailedSchema.deviceId
    var disbursalAmount by QikPlAvailedSchema.disbursalAmount
    var disbursalDate by QikPlAvailedSchema.disbursalDate
    var emiDueDate by QikPlAvailedSchema.emiDueDate
    var firstEmiDate by QikPlAvailedSchema.firstEmiDate
    var healthDeclaration by QikPlAvailedSchema.healthDeclaration
    var insurancePlanId by QikPlAvailedSchema.insurancePlanId
    var insurancePremium by QikPlAvailedSchema.insurancePremium
    var isIplAvailed by QikPlAvailedSchema.isIplAvailed
    var lastUpdatedTimestamp by QikPlAvailedSchema.lastUpdatedTimestamp
    var plAmount by QikPlAvailedSchema.plAmount
    var plEmi by QikPlAvailedSchema.plEmi
    var plLeadId by QikPlAvailedSchema.plLeadId
    var plProcessingFee by QikPlAvailedSchema.plProcessingFee
    var plRoi by QikPlAvailedSchema.plRoi
    var plTenure by QikPlAvailedSchema.plTenure
    var tncVersion by QikPlAvailedSchema.tncVersion
    var instantCreditStatus by QikPlAvailedSchema.instantCreditStatus
    var isCalculatorProceed by QikPlAvailedSchema.isCalculatorProceed
    var isConfirmAddressProceed by QikPlAvailedSchema.isConfirmAddressProceed
    var isInputVariableProceed by QikPlAvailedSchema.isInputVariableProceed
    var isKycModeProceed by QikPlAvailedSchema.isKycModeProceed
    var isOfferProceed by QikPlAvailedSchema.isOfferProceed
    var isOtpProceed by QikPlAvailedSchema.isOtpProceed
    var isReviewProceed by QikPlAvailedSchema.isReviewProceed
    var isTcProceed by QikPlAvailedSchema.isTcProceed
    var loanAccountNumber by QikPlAvailedSchema.loanAccountNumber
    var maskedBank by QikPlAvailedSchema.maskedBank
    var plLoanRefNumber by QikPlAvailedSchema.plLoanRefNumber
    var rejection by QikPlAvailedSchema.rejection
    var rejectionReason by QikPlAvailedSchema.rejectionReason
    var loanAgreementUrl by QikPlAvailedSchema.loanAgreementUrl
    var loanDetailsUrl by QikPlAvailedSchema.loanDetailsUrl
    var termsAndConditionsUrl by QikPlAvailedSchema.termsAndConditionsUrl
    var loanApplicationUrl by QikPlAvailedSchema.loanApplicationUrl
    var plWebtopId by QikPlAvailedSchema.plWebtopId
    var gcid by QikPlAvailedSchema.gcid
    var loanAccountNumberDate by QikPlAvailedSchema.loanAccountNumberDate
    var emiEndDate by QikPlAvailedSchema.emiEndDate
    var agreementDate by QikPlAvailedSchema.agreementDate
    var amountCreditedInBank by QikPlAvailedSchema.amountCreditedInBank
    var offerType by QikPlAvailedSchema.offerType
    var apr by QikPlAvailedSchema.apr
}

class PlTransactionEntities(plTransactionId: EntityID<String>) : Entity<String>(plTransactionId) {
    companion object : EntityClass<String, PlTransactionEntities>(PlTransactionSchema)
    var plTransactionId by PlTransactionSchema.plTransactionId
    var customerInfoId by PlTransactionSchema.customerInfoId
    var partnerLoanApplicationNum by PlTransactionSchema.partnerLoanApplicationNum
    var partnerLoanApplicationId by PlTransactionSchema.partnerLoanApplicationId
    var lenderId by PlTransactionSchema.lenderId
    var type by PlTransactionSchema.type
    var appliedAmount by PlTransactionSchema.appliedAmount
    var tenure by PlTransactionSchema.tenure
    var rateOfInterest by PlTransactionSchema.rateOfInterest
    var status by PlTransactionSchema.status
    var name by PlTransactionSchema.name
    var createdAt by PlTransactionSchema.createdAt
    var email by PlTransactionSchema.email
    var mobile by PlTransactionSchema.mobile
    var gender by PlTransactionSchema.gender
    var dob by PlTransactionSchema.dob
    var pan by PlTransactionSchema.pan
    var addressLine1 by PlTransactionSchema.addressLine1
    var addressLine2 by PlTransactionSchema.addressLine2
    var city by PlTransactionSchema.city
    var pincode by PlTransactionSchema.pincode
    var state by PlTransactionSchema.state
    var educationLevel by PlTransactionSchema.educationLevel
    var dependents by PlTransactionSchema.dependents
    var expenses by PlTransactionSchema.expenses
    var fathersName by PlTransactionSchema.fathersName
    var income by PlTransactionSchema.income
    var loanPurpose by PlTransactionSchema.loanPurpose
    var maritalStatus by PlTransactionSchema.maritalStatus
    var referenceContact by PlTransactionSchema.referenceContact
    var referenceContactName by PlTransactionSchema.referenceContactName
    var referenceRelationship by PlTransactionSchema.referenceRelationship
    var residenceType by PlTransactionSchema.residenceType
    var accountNumber by PlTransactionSchema.accountNumber
    var ifscCode by PlTransactionSchema.ifscCode
    var bankName by PlTransactionSchema.bankName
    var accountHolderName by PlTransactionSchema.accountHolderName
    var insurancePremium by PlTransactionSchema.insurancePremium
    var insurancePlanName by PlTransactionSchema.insurancePlanName
    var processingFee by PlTransactionSchema.processingFee
    var disbursalAmount by PlTransactionSchema.disbursalAmount
    var advanceEmi by PlTransactionSchema.advanceEmi
    var emiAmount by PlTransactionSchema.emiAmount
    var stampDutyCharge by PlTransactionSchema.stampDutyCharge
    var referenceName by PlTransactionSchema.referenceName
    var createdOn by PlTransactionSchema.createdOn
    var createdBy by PlTransactionSchema.createdBy
    var updatedOn by PlTransactionSchema.updatedOn
    var updatedBy by PlTransactionSchema.updatedBy
}

class PlEventAuditEntities(eventTypeId: EntityID<String>) : Entity<String>(eventTypeId) {
    companion object : EntityClass<String, PlEventAuditEntities>(PlEventAuditSchema)
    var eventTypeId by PlEventAuditSchema.eventTypeId
    var partnerCustomerId by PlEventAuditSchema.partnerCustomerId
    var eventType by PlEventAuditSchema.eventType
    var partnerLoanApplicationId by PlEventAuditSchema.partnerLoanApplicationId
    var createdOn by PlEventAuditSchema.createdOn
    var createdBy by PlEventAuditSchema.createdBy
    var updatedOn by PlEventAuditSchema.updatedOn
    var updatedBy by PlEventAuditSchema.updatedBy
}

class CustomerConsentEntity(consentId: EntityID<Long>) : Entity<Long>(consentId) {
    companion object: EntityClass<Long, CustomerConsentEntity>(CustomerConsentSchema)
    var consentId by CustomerConsentSchema.consentId
    var customerHash by CustomerConsentSchema.customerHash
    var consentType by CustomerConsentSchema.consentType
    var ipAddress by CustomerConsentSchema.ipAddress
    var deviceId by CustomerConsentSchema.deviceId
    var version by CustomerConsentSchema.version
    var consentTimestamp by CustomerConsentSchema.consentTimestamp
    var lastUpdatedTimestamp by CustomerConsentSchema.lastUpdatedTimestamp
    var finBoxSource by CustomerConsentSchema.finBoxSource
}
