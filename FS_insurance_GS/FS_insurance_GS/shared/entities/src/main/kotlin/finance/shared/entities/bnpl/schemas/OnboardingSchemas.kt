package finance.shared.entities.bnpl.schemas

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.javatime.date
import org.jetbrains.exposed.sql.javatime.datetime

object Customers : IdTable<String>("customers") {

    val customerHash = varchar("customer_hash", 255).uniqueIndex()
    val customerId = varchar("customer_id", 255).nullable()
    val mobileNumber = varchar("mobile_number", 255).nullable()
    val firstName = varchar("first_name", 255).nullable()
    val lastName = varchar("last_name", 255).nullable()
    val pan = varchar("pan", 255).nullable()
    val emailId = varchar("email_id", 255).nullable()
    val dob = date("dob").nullable()
    val pin = varchar("pin", 255).nullable()
    val employmentType = varchar("employment_type", 255).nullable()
    val monthlyIncome = double("monthly_income").nullable()
    val gender = varchar("gender", 255).nullable()
    val createdBy = varchar("createdby", 255)
    val createdOn = datetime("createdon")
    val lastUpdatedBy = varchar("lastupdatedby", 255)
    val lastUpdatedOn = datetime("lastupdatedon")
    val fullName = varchar("full_name", 255).nullable()
    val occupation = varchar("occupation", 255).nullable()
    val deviceId = varchar("device_id", 255).nullable()

    override val id: Column<EntityID<String>> = customerHash.entityId()

}

object PreApprovedOffers : IdTable<String>("pre_approved_offers") {

    val customerHash = varchar("customer_hash", 255)
    val offerId = varchar("offer_id", 255).uniqueIndex()
    val lenderId = varchar("lender_id", 255)
    val paFlag = varchar("pa_flag", 255).nullable()
    val createdBy = varchar("createdby", 255)
    val createdOn = datetime("createdon")
    val lastUpdatedBy = varchar("lastupdatedby", 255)
    val lastUpdatedOn = datetime("lastupdatedon")
    val limitType = varchar("limit_type", 255)
    val tenure = varchar("tenure", 255)
    val tenureType = varchar("tenure_type", 255)
    val validTill = date("valid_till")
    val aggregateLimit = double("aggregate_limit")
    val sanctionedAmount = double("sanctioned_amount")
    val drawingCapacity = double("drawing_capacity")
    val drawingCapacityTenureType =
        varchar("drawing_capacity_tenure_type", 255)
    val lenderName = varchar("lender_name", 255)
    val kycRequired = bool("kyc_required")
    val enachRequired = bool("enach_required")
    override val id: Column<EntityID<String>> = offerId.entityId()
}


object LimitDetails : IdTable<Int>("limit_details") {
    var lid = integer("id").uniqueIndex()
    var limitId = varchar("limit_id", 255).nullable()
    var offerId = reference("offer_id", OfferDetails)
    var tenure = varchar("tenure", 255)
    var tenureType = varchar("tenure_type", 255)
    var sanctionedAmount = double("sanctioned_amount")
    var drawingCapacityTenureType = varchar("drawing_capacity_tenure_type", 255)
    var status = varchar("status", 255)
    var drawingCapacity = double("drawing_capacity")
    var instrument = varchar("instrument", 255)
    var createdBy = varchar("created_by", 255)
    var createdOn = datetime("created_on")
    var lastUpdatedBy = varchar("last_updated_by", 255)
    var lastUpdatedOn = datetime("last_updated_on")
    var isActivated = bool("is_activated").default(false)
    var eventLoggedAt = datetime("event_logged_at").nullable()
    override val id: Column<EntityID<Int>> = lid.entityId().autoIncrement()
}


object OfferDetails : IdTable<String>("offer_details") {

    var offerId = varchar("offer_id", 255).uniqueIndex()
    var customerId = varchar("customer_id", 255)
    var lenderId = varchar("lender_id", 255)
    var offerSource = varchar("offer_source", 255)
    var lenderName = varchar("lender_name", 255)
    var lenderLogo = varchar("lender_logo", 255).nullable()
    var kycRequirded = bool("kyc_required").nullable()
    var enachRequired = bool("enach_required").nullable()
    var aggregateLimit = double("aggregate_limit")
    var validTill = date("valid_till")
    var offerStatus = varchar("offer_status", 255)
    var createdBy = varchar("created_by", 255)
    var createdOn = datetime("created_on")
    var lastUpdatedBy = varchar("last_updated_by", 255)
    var lastUpdatedOn = datetime("last_updated_on")
    var isRecommended = bool("is_recommended")
    var eventLoggedAt = datetime("event_logged_at").nullable()
    var loanProductType = varchar("loan_product_type", 255).nullable()
    var loanProductId = varchar("loan_product_id", 255).nullable()
    var inActiveReason = varchar("inactive_reason", 255).nullable()
    override val id: Column<EntityID<String>> = offerId.entityId()
}

object ConsentForms: IntIdTable("consentform") {
    var product = varchar("product",255)
    var page = varchar("page",255)
    var consentVersion = varchar("consent_version",255)
    var status = varchar("status",255)
    var createdOn = datetime("created_on")
    var createdBy = varchar("created_by",255)
    var updatedOn = datetime("updated_on")
    var updatedBy = varchar("updated_by",255)
}

object CustomerConsents: IntIdTable("customer_consent") {
    var consentForm = reference("consent_form_id",ConsentForms)
    var consent = bool("consent")
    var customerHash = varchar("customer_hash",255)
    var deviceId = varchar("device_id",255)
    var status = varchar("status",255)
    var createdOn = datetime("created_on")
    var createdBy = varchar("created_by",255)
    var updatedOn = datetime("updated_on")
    var updatedBy = varchar("updated_by",255)
}