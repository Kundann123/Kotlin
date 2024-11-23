package finance.shared.util.onboarding

import org.ktorm.entity.Entity
import java.time.LocalDate
import java.time.LocalDateTime

interface Customer : Entity<Customer> {
    companion object : Entity.Factory<Customer>()

    val customerHash: String
    var customerId: String
    val mobileNumber: String
    val firstName: String
    val lastName: String
    val pan: String
    val emailId: String
    val dob: LocalDate
    val pin: String
    val employmentType: String
    val monthlyIncome: Double
    val gender: String
    val createdBy: String
    val createdOn: LocalDateTime
    val lastUpdatedBy: String
    val lastUpdatedOn: LocalDateTime
    val fullName: String
    val occupation: String
    val deviceId: String
    val deviceInfo: String


}

interface PreApprovedOffer : Entity<PreApprovedOffer> {
    companion object : Entity.Factory<PreApprovedOffer>()

    val customerHash: String
    val offerId: String
    val lenderId: String
    val paFlag: String
    val createdBy: String
    val createdOn: LocalDateTime
    val lastUpdatedBy: String
    val lastUpdatedOn: LocalDateTime
    var limitType: String
    val tenure: String
    val tenureType: String
    val validTill: LocalDate
    val aggregateLimit: Double
    var sanctionedAmount: Double
    val drawingCapacity: Double
    val drawingCapacityTenureType: String
    var lenderName: String
    var kycRequired: Boolean
    var enachRequired: Boolean


}

interface Offer : Entity<Offer> {
    companion object : Entity.Factory<Offer>()

    var offerId: String
    var customerId: String
    var lenderId: String
    var offerSource: String
    var isRecommended: Boolean
    var lenderName: String
    var aggregateLimit: Double
    var loanProductType: String
    var validTill: LocalDate
    var loanProductId: String
    var lenderLogo: String
    var borrowerId: String
    var kycRequired: Boolean
    var enachRequired: Boolean
    var isActivated: Boolean
    var offerStatus: String
    var isRejected: Boolean
    var lastUpdatedOn: LocalDateTime
    var createdOn: LocalDateTime
    var lastUpdatedBy: String
    var createdBy: String
    var loanApplicationId: String
    var eventLoggedAt: LocalDateTime
}

interface Limit : Entity<Limit> {
    companion object : Entity.Factory<Limit>()

    var limitId: String
    var offerId: Offer
    var tenure: String
    var tenureType: String
    var sanctionedAmount: Double
    var drawingCapacityTenureType: String
    var status: String
    var lastUpdatedOn: LocalDateTime
    var createdOn: LocalDateTime
    var lastUpdatedBy: String
    var createdBy: String
    var drawingCapacity: Double
    var availableLimit: Double
    var minAmount: Double
    var inactiveReason: String
    var instrument: String
    var eventLoggedAt: LocalDateTime
}