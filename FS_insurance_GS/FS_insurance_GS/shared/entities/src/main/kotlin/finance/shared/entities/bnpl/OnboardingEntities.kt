package finance.shared.entities.bnpl


import finance.shared.entities.bnpl.schemas.*
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID


class Customer(customerHash: EntityID<String>) : Entity<String>(customerHash) {
    companion object : EntityClass<String, Customer>(Customers)

    var customerHash by Customers.customerHash
    var customerId by Customers.customerId
    var mobileNumber by Customers.mobileNumber
    var firstName by Customers.firstName
    var lastName by Customers.lastName
    var pan by Customers.pan
    var emailId by Customers.emailId
    var dob by Customers.dob
    var pin by Customers.pin
    var employmentType by Customers.employmentType
    var monthlyIncome by Customers.monthlyIncome
    var gender by Customers.gender
    var createdBy by Customers.createdBy
    var createdOn by Customers.createdOn
    var lastUpdatedBy by Customers.lastUpdatedBy
    var lastUpdatedOn by Customers.lastUpdatedOn
    var fullName by Customers.fullName
    var occupation by Customers.occupation
    var deviceId by Customers.deviceId
}

class PreApprovedOffer(customerHash: EntityID<String>) : Entity<String>(customerHash) {
    companion object : EntityClass<String, PreApprovedOffer>(PreApprovedOffers)

    var customerHash by PreApprovedOffers.customerHash
    var offerId by PreApprovedOffers.offerId
    var lenderId by PreApprovedOffers.lenderId
    var paFlag by PreApprovedOffers.paFlag
    var createdBy by PreApprovedOffers.createdBy
    var createdOn by PreApprovedOffers.createdOn
    var lastUpdatedBy by PreApprovedOffers.lastUpdatedBy
    var lastUpdatedOn by PreApprovedOffers.lastUpdatedOn
    var limitType by PreApprovedOffers.limitType
    var tenure by PreApprovedOffers.tenure
    var tenureType by PreApprovedOffers.tenureType
    var validTill by PreApprovedOffers.validTill
    var aggregateLimit by PreApprovedOffers.aggregateLimit
    var sanctionedAmount by PreApprovedOffers.sanctionedAmount
    var drawingCapacity by PreApprovedOffers.drawingCapacity
    var drawingCapacityTenureType by PreApprovedOffers.drawingCapacityTenureType
    var lenderName by PreApprovedOffers.lenderName
    var kycRequired by PreApprovedOffers.kycRequired
    var enachRequired by PreApprovedOffers.enachRequired
}

class OfferDetail(offerId: EntityID<String>) : Entity<String>(offerId) {
    companion object : EntityClass<String, OfferDetail>(OfferDetails)

    var offerId by OfferDetails.offerId
    var customerId by OfferDetails.customerId
    var lenderId by OfferDetails.lenderId
    var offerSource by OfferDetails.offerSource
    var lenderName by OfferDetails.lenderName
    var aggregateLimit by OfferDetails.aggregateLimit
    var validTill by OfferDetails.validTill
    var createdOn by OfferDetails.createdOn
    var createdBy by OfferDetails.createdBy
    var lastUpdatedOn by OfferDetails.lastUpdatedOn
    var lastUpdatedBy by OfferDetails.lastUpdatedBy
    var isRecommended by OfferDetails.isRecommended
    var offerStatus by OfferDetails.offerStatus
    var eventLoggedAt by OfferDetails.eventLoggedAt
    var kycRequirded by OfferDetails.kycRequirded
    var enachRequired by OfferDetails.enachRequired
    var loanProductType by OfferDetails.loanProductType
    var loanProductId by OfferDetails.loanProductId
    var lenderLogo by OfferDetails.lenderLogo
    val limitDetails by LimitDetail referrersOn LimitDetails.offerId
}

class LimitDetail(lid: EntityID<Int>) : Entity<Int>(lid) {
    companion object : EntityClass<Int, LimitDetail>(LimitDetails)

    val lid by LimitDetails.lid
    var limitId by LimitDetails.limitId
    var offerId by OfferDetail referencedOn LimitDetails.offerId
    var tenure by LimitDetails.tenure
    var tenureType by LimitDetails.tenureType
    var sanctionedAmount by LimitDetails.sanctionedAmount
    var drawingCapacityTenureType by LimitDetails.drawingCapacityTenureType
    var status by LimitDetails.status
    var drawingCapacity by LimitDetails.drawingCapacity
    var instrument by LimitDetails.instrument
    var createdOn by LimitDetails.createdOn
    var createdBy by LimitDetails.createdBy
    var lastUpdatedOn by LimitDetails.lastUpdatedOn
    var lastUpdatedBy by LimitDetails.lastUpdatedBy
    var isActivated by LimitDetails.isActivated
    var eventLoggedAt by LimitDetails.eventLoggedAt

}

class ConsentForm (id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<ConsentForm>(ConsentForms)
    var product by ConsentForms.product
    var page by ConsentForms.page
    var consentVersion by ConsentForms.consentVersion
    var status by ConsentForms.status
    var createdOn by ConsentForms.createdOn
    var createdBy by ConsentForms.createdBy
    var updatedOn by ConsentForms.updatedOn
    var updatedBy by ConsentForms.updatedBy
}

class CustomerConsent (id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<CustomerConsent>(CustomerConsents)
    var consentForm by ConsentForm referencedOn CustomerConsents.consentForm
    var consent by CustomerConsents.consent
    var customerHash by CustomerConsents.customerHash
    var deviceId by CustomerConsents.deviceId
    var status by CustomerConsents.status
    var createdOn by CustomerConsents.createdOn
    var createdBy by CustomerConsents.createdBy
    var updatedOn by CustomerConsents.updatedOn
    var updatedBy by CustomerConsents.updatedBy
}