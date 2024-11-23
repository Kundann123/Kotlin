package finance.shared.util.onboarding

import org.ktorm.schema.*
import java.time.LocalDateTime

object Customers : Table<Customer>("customers") {

    val customerHash = varchar("customer_hash").primaryKey().bindTo(Customer::customerHash)
    val customerId = varchar("customer_id").bindTo(Customer::customerId)
    val mobileNumber = varchar("mobile_number").bindTo(Customer::mobileNumber)
    val firstName = varchar("first_name").bindTo(Customer::firstName)
    val lastName = varchar("last_name").bindTo(Customer::lastName)
    val pan = varchar("pan").bindTo(Customer::pan)
    val emailId = varchar("email_id").bindTo(Customer::emailId)
    val dob = date("dob").bindTo(Customer::dob)
    val pin = varchar("pin").bindTo(Customer::pin)
    val employmentType = varchar("employment_type").bindTo(Customer::employmentType)
    val monthlyIncome = double("monthly_income").bindTo(Customer::monthlyIncome)
    val gender = varchar("gender").bindTo(Customer::gender)
    val createdBy = varchar("createdby").bindTo(Customer::createdBy)
    val createdOn = datetime("createdon").bindTo(Customer::createdOn)
    val lastUpdatedBy = varchar("lastupdatedby").bindTo(Customer::lastUpdatedBy)
    val lastUpdatedOn = datetime("lastupdatedon").bindTo(Customer::lastUpdatedOn)
    val fullName = varchar("full_name").bindTo(Customer::fullName)
    val occupation = varchar("occupation").bindTo(Customer::occupation)
    val deviceId = varchar("device_id").bindTo(Customer::deviceId)
    val deviceInfo = varchar("device_info").bindTo(Customer::deviceInfo)

}

object PreApprovedOffers : Table<PreApprovedOffer>("pre_approved_offers") {

    val customerHash = varchar("customer_hash").primaryKey().bindTo(PreApprovedOffer::customerHash)
    val offerId = varchar("offer_id").bindTo(PreApprovedOffer::offerId)
    val lenderId = varchar("lender_id").bindTo(PreApprovedOffer::lenderId)
    val paFlag = varchar("pa_flag").bindTo(PreApprovedOffer::paFlag)
    val createdBy = varchar("createdby").bindTo(PreApprovedOffer::createdBy)
    val createdOn = datetime("createdon").bindTo(PreApprovedOffer::createdOn)
    val lastUpdatedBy = varchar("lastupdatedby").bindTo(PreApprovedOffer::lastUpdatedBy)
    val lastUpdatedOn = datetime("lastupdatedon").bindTo(PreApprovedOffer::lastUpdatedOn)
    val limitType = varchar("limit_type").bindTo(PreApprovedOffer::limitType)
    val tenure = varchar("tenure").bindTo(PreApprovedOffer::tenure)
    val tenureType = varchar("tenure_type").bindTo(PreApprovedOffer::tenureType)
    val validTill = date("valid_till").bindTo(PreApprovedOffer::validTill)
    val aggregateLimit = double("aggregate_limit").bindTo(PreApprovedOffer::aggregateLimit)
    val sanctionedAmount = double("sanctioned_amount").bindTo(PreApprovedOffer::sanctionedAmount)
    val drawingCapacity = double("drawing_capacity").bindTo(PreApprovedOffer::drawingCapacity)
    val drawingCapacityTenureType =
        varchar("drawing_capacity_tenure_type").bindTo(PreApprovedOffer::drawingCapacityTenureType)
    val lenderName = varchar("employment_type").bindTo(PreApprovedOffer::lenderName)
    val kycRequired = boolean("kyc_required").bindTo(PreApprovedOffer::kycRequired)
    val enachRequired = boolean("enach_required").bindTo(PreApprovedOffer::enachRequired)

}


object LimitDetails : Table<Limit>("limit_details") {
    val limitId = varchar("limit_id").primaryKey().bindTo(Limit::limitId)
    val offerId = varchar("offer_id").references(OfferDetails) { it.offerId }
    val tenure = varchar("tenure").bindTo(Limit::tenure)
    val tenureType = varchar("tenure_type").bindTo(Limit::tenureType)
    val sanctionedAmount = double("sanctioned_amount").bindTo(Limit::sanctionedAmount)
    val drawingCapacityTenureType = varchar("drawing_capacity_tenure_type").bindTo(Limit::drawingCapacityTenureType)
    val status = varchar("status").bindTo(Limit::status)
    val lastUpdatedOn = datetime("last_updated_on").bindTo(Limit::lastUpdatedOn)
    val createdOn = datetime("created_on").bindTo(Limit::createdOn)
    val lastUpdatedBy = varchar("last_updated_by").bindTo(Limit::lastUpdatedBy)
    val createdBy = varchar("created_by").bindTo(Limit:: createdBy)
    val drawingCapacity = double("drawing_capacity").bindTo(Limit::drawingCapacity)
    val availableLimit = double("available_limit").bindTo(Limit::availableLimit)
    val minAmount = double("min_amount").bindTo(Limit::minAmount)
    val inactiveReason = varchar("inactive_reason").bindTo(Limit::inactiveReason)
    val instrument = varchar("instrument").bindTo(Limit::instrument)
    val eventLoggedAt = datetime("event_logged_at").bindTo(Limit::eventLoggedAt)
}


object OfferDetails : Table<Offer>("offer_details") {

    val offerId = varchar("offer_id").primaryKey().bindTo(Offer::offerId)
    val customerId = varchar("customer_id").bindTo(Offer::customerId)
    val lenderId = varchar("lender_id").bindTo(Offer::lenderId)
    val offerSource = varchar("offer_source").bindTo(Offer::offerSource)
    val isRecommended = boolean("is_recommended").bindTo(Offer::isRecommended)
    val lenderName = varchar("lender_name").bindTo(Offer::lenderName)
    val aggregateLimit = double("aggregate_limit").bindTo(Offer::aggregateLimit)
    val loanProductType = varchar("loan_product_type").bindTo(Offer::loanProductType)
    val validTill = date("valid_till").bindTo(Offer::validTill)
    val loanProductId = varchar("loan_product_id").bindTo(Offer::loanProductId)
    val lenderLogo = varchar("lender_logo").bindTo(Offer::lenderLogo)
    val borrowerId = varchar("borrower_id").bindTo(Offer::borrowerId)
    val kycRequired = boolean("kyc_required").bindTo(Offer::kycRequired)
    val enachRequired = boolean("enach_required").bindTo(Offer::enachRequired)
    val isActivated = boolean("is_activated").bindTo(Offer::isActivated)
    val offerStatus = varchar("offer_status").bindTo(Offer::offerStatus)
    val isRejected = boolean("is_rejected").bindTo(Offer::isRejected)
    val lastUpdatedOn = datetime("last_updated_on").bindTo(Offer::lastUpdatedOn)
    val createdOn = datetime("created_on").bindTo(Offer::createdOn)
    val lastUpdatedBy = varchar("last_updated_by").bindTo(Offer::lastUpdatedBy)
    val createdBy = varchar("created_by").bindTo(Offer::createdBy)
    val loanApplicationId = varchar("loan_application_id").bindTo(Offer::loanApplicationId)
    val eventLoggedAt = datetime("event_logged_at").bindTo(Offer::eventLoggedAt)


}

