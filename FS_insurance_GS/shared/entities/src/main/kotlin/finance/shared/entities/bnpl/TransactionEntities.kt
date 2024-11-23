package finance.shared.entities.bnpl


import finance.shared.entities.bnpl.schemas.*
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID


class LoanTransaction(transactionId: EntityID<String>) : Entity<String>(transactionId) {
    companion object : EntityClass<String, LoanTransaction>(LoanTransactions)

    var transactionId by LoanTransactions.transactionId
    var totalAmount by LoanTransactions.totalAmount
    var lenderName by LoanTransactions.lenderName
    var lender by LenderMaster referencedOn LoanTransactions.lender
    var tender by Tender referencedOn LoanTransactions.tender
    var merchant by MerchantMaster referencedOn LoanTransactions.merchant
    var merchantOrderId by LoanTransactions.merchantOrderId
    var orderId by LoanTransactions.orderId
    var customerHash by LoanTransactions.customerHash
    var customerID by LoanTransactions.customerID
    var minDownPayment by LoanTransactions.minDownPayment
    var maxDownPayment by LoanTransactions.maxDownPayment
    var downPayment by LoanTransactions.downPayment
    var dealerId by LoanTransactions.dealerId
    var limitId by LoanTransactions.limitId
    var paymentId by LoanTransactions.paymentId
    var otpResendCount by LoanTransactions.otpResendCount
    var otpAuthId by LoanTransactions.otpAuthId
    var pincode by LoanTransactions.pincode
    var status by LoanTransactions.status
    var createdOn by LoanTransactions.createdOn
    var createdBy by LoanTransactions.createdBy
    var updatedOn by LoanTransactions.updatedOn
    var updatedBy by LoanTransactions.updatedBy
    val loanSubTransactions by LoanSubTransaction referrersOn LoanSubTransactions.loanTransactionId
}

class LoanSubTransaction(subTransactionId: EntityID<String>) : Entity<String>(subTransactionId) {
    companion object : EntityClass<String, LoanSubTransaction>(LoanSubTransactions)

    var loanTransactionId by LoanTransaction referencedOn LoanSubTransactions.loanTransactionId
    var subTransactionId by LoanSubTransactions.subTransactionId
    var type by LoanSubTransactions.type
    var neuCoins by LoanSubTransactions.neuCoins
    var loanAmount by LoanSubTransactions.loanAmount
    var minDownPayment by LoanSubTransactions.minDownPayment
    var maxDownPayment by LoanSubTransactions.maxDownPayment
    var downPayment by LoanSubTransactions.downPayment
    var prePayment by LoanSubTransactions.prePayment
    var advanceEmiCount by LoanSubTransactions.advanceEmiCount
    var advanceEmiAmount by LoanSubTransactions.advanceEmiAmount
    var rateOfInterest by LoanSubTransactions.rateOfInterest
    var status by LoanSubTransactions.status
    var createdOn by LoanSubTransactions.createdOn
    var createdBy by LoanSubTransactions.createdBy
    var updatedOn by LoanSubTransactions.updatedOn
    var updatedBy by LoanSubTransactions.updatedBy
    var lenderDiscount by LoanSubTransactions.lenderDiscount
    val transactionProducts by TransactionProduct referrersOn TransactionProducts.subTransaction
    val transactionSchemes by TransactionScheme referrersOn TransactionSchemes.subTransaction

}

class TransactionProduct(transactionProductId: EntityID<String>) : Entity<String>(transactionProductId) {
    companion object : EntityClass<String, TransactionProduct>(TransactionProducts)

    var transactionProductId by TransactionProducts.transactionProductId
    var subTransaction by LoanSubTransaction referencedOn TransactionProducts.subTransaction
    var imeiNumber by TransactionProducts.imeiNumber
    var category by TransactionProducts.category
    var color by TransactionProducts.color
    var skuId by TransactionProducts.skuId
    var modelId by TransactionProducts.modelId
    var price by TransactionProducts.price
    var description by TransactionProducts.description
    var serialNumber by TransactionProducts.serialNumber
    var status by TransactionProducts.status
    var createdOn by TransactionProducts.createdOn
    var createdBy by TransactionProducts.createdBy
    var updatedOn by TransactionProducts.updatedOn
    var updatedBy by TransactionProducts.updatedBy
}

class TransactionScheme(transactionProductSchmId: EntityID<String>) : Entity<String>(transactionProductSchmId) {
    companion object : EntityClass<String, TransactionScheme>(TransactionSchemes)

    var subTransaction by LoanSubTransaction referencedOn TransactionSchemes.subTransaction
    var transactionSchmId by TransactionSchemes.transactionSchmId
    var schmId by TransactionSchemes.schmId
    var tenure by TransactionSchemes.tenure
    var processingFee by TransactionSchemes.processingFee
    var tenureType by TransactionSchemes.tenureType
    var emiDiscount by TransactionSchemes.emiDiscount
    var emi by TransactionSchemes.emi
    var isSelected by TransactionSchemes.isSelected
    var isNoCost by TransactionSchemes.isNoCost
    var interest by TransactionSchemes.interest
    var status by TransactionSchemes.status
    var createdOn by TransactionSchemes.createdOn
    var createdBy by TransactionSchemes.createdBy
    var updatedOn by TransactionSchemes.updatedOn
    var updatedBy by TransactionSchemes.updatedBy
}

class LoanTransactionStaging(transactionId: EntityID<String>) : Entity<String>(transactionId) {
    companion object : EntityClass<String, LoanTransactionStaging>(LoanTransactionsStaging)

    var transactionId by LoanTransactionsStaging.transactionId
    var totalAmount by LoanTransactionsStaging.totalAmount
    var lenderName by LoanTransactionsStaging.lenderName
    var lender by LenderMaster referencedOn LoanTransactionsStaging.lender
    var tender by Tender referencedOn LoanTransactionsStaging.tender
    var merchant by MerchantMaster referencedOn LoanTransactionsStaging.merchant
    var merchantOrderId by LoanTransactionsStaging.merchantOrderId
    var orderId by LoanTransactionsStaging.orderId
    var customerHash by LoanTransactionsStaging.customerHash
    var customerID by LoanTransactionsStaging.customerID
    var minDownPayment by LoanTransactionsStaging.minDownPayment
    var maxDownPayment by LoanTransactionsStaging.maxDownPayment
    var downPayment by LoanTransactionsStaging.downPayment
    var dealerId by LoanTransactionsStaging.dealerId
    var limitId by LoanTransactionsStaging.limitId
    var paymentId by LoanTransactionsStaging.paymentId
    var otpResendCount by LoanTransactionsStaging.otpResendCount
    var otpAuthId by LoanTransactionsStaging.otpAuthId
    var pincode by LoanTransactionsStaging.pincode
    var status by LoanTransactionsStaging.status
    var createdOn by LoanTransactionsStaging.createdOn
    var createdBy by LoanTransactionsStaging.createdBy
    var updatedOn by LoanTransactionsStaging.updatedOn
    var updatedBy by LoanTransactionsStaging.updatedBy
    val subLoanTransactions by LoanSubTransactionStaging referrersOn LoanSubTransactionsStaging.loanTransactionId
}

class LoanSubTransactionStaging(subTransactionId: EntityID<String>) : Entity<String>(subTransactionId) {
    companion object : EntityClass<String, LoanSubTransactionStaging>(LoanSubTransactionsStaging)

    var loanTransactionId by LoanTransactionStaging referencedOn LoanSubTransactionsStaging.loanTransactionId
    var subTransactionId by LoanSubTransactionsStaging.subTransactionId
    var type by LoanSubTransactionsStaging.type
    var neuCoins by LoanSubTransactionsStaging.neuCoins
    var loanAmount by LoanSubTransactionsStaging.loanAmount
    var minDownPayment by LoanSubTransactionsStaging.minDownPayment
    var maxDownPayment by LoanSubTransactionsStaging.maxDownPayment
    var downPayment by LoanSubTransactionsStaging.downPayment
    var prePayment by LoanSubTransactionsStaging.prePayment
    var advanceEmiCount by LoanSubTransactionsStaging.advanceEmiCount
    var advanceEmiAmount by LoanSubTransactionsStaging.advanceEmiAmount
    var rateOfInterest by LoanSubTransactionsStaging.rateOfInterest
    var status by LoanSubTransactionsStaging.status
    var createdOn by LoanSubTransactionsStaging.createdOn
    var createdBy by LoanSubTransactionsStaging.createdBy
    var updatedOn by LoanSubTransactionsStaging.updatedOn
    var updatedBy by LoanSubTransactionsStaging.updatedBy
    var lenderDiscount by LoanSubTransactionsStaging.lenderDiscount
    val transactionProducts by TransactionProductStaging referrersOn TransactionProductsStaging.subTransaction
    val transactionSchemes by TransactionSchemeStaging referrersOn TransactionSchemesStaging.subTransaction
}

class TransactionProductStaging(transactionProductId: EntityID<String>) : Entity<String>(transactionProductId) {
    companion object : EntityClass<String, TransactionProductStaging>(TransactionProductsStaging)

    var transactionProductId by TransactionProductsStaging.transactionProductId
    var subTransaction by LoanSubTransactionStaging referencedOn TransactionProductsStaging.subTransaction
    var imeiNumber by TransactionProductsStaging.imeiNumber
    var category by TransactionProductsStaging.category
    var color by TransactionProductsStaging.color
    var skuId by TransactionProductsStaging.skuId
    var modelId by TransactionProductsStaging.modelId
    var price by TransactionProductsStaging.price
    var description by TransactionProductsStaging.description
    var serialNumber by TransactionProductsStaging.serialNumber
    var status by TransactionProductsStaging.status
    var createdOn by TransactionProductsStaging.createdOn
    var createdBy by TransactionProductsStaging.createdBy
    var updatedOn by TransactionProductsStaging.updatedOn
    var updatedBy by TransactionProductsStaging.updatedBy

}

class TransactionSchemeStaging(transactionSchmId: EntityID<String>) :
    Entity<String>(transactionSchmId) {
    companion object : EntityClass<String, TransactionSchemeStaging>(TransactionSchemesStaging)

    var subTransaction by LoanSubTransactionStaging referencedOn TransactionSchemesStaging.subTransaction
    var transactionSchmId by TransactionSchemesStaging.transactionSchmId
    var schmId by TransactionSchemesStaging.schmId
    var tenure by TransactionSchemesStaging.tenure
    var processingFee by TransactionSchemesStaging.processingFee
    var tenureType by TransactionSchemesStaging.tenureType
    var emiDiscount by TransactionSchemesStaging.emiDiscount
    var isNoCost by TransactionSchemesStaging.isNoCost
    var emi by TransactionSchemesStaging.emi
    var isSelected by TransactionSchemesStaging.isSelected
    var interest by TransactionSchemesStaging.interest
    var status by TransactionSchemesStaging.status
    var createdOn by TransactionSchemesStaging.createdOn
    var createdBy by TransactionSchemesStaging.createdBy
    var updatedOn by TransactionSchemesStaging.updatedOn
    var updatedBy by TransactionSchemesStaging.updatedBy
}


class Tender(tenderId: EntityID<String>) : Entity<String>(tenderId) {
    companion object : EntityClass<String, Tender>(TendersMaster)

    var tenderId by TendersMaster.tenderId
    var tenderCode by TendersMaster.tenderCode
    var tenderDesc by TendersMaster.tenderDesc
    var status by TendersMaster.status
    var createdOn by TendersMaster.createdOn
    var createdBy by TendersMaster.createdBy
    var updatedOn by TendersMaster.updatedOn
    var updatedBy by TendersMaster.updatedBy
}

class Limit(limitId: EntityID<String>) : Entity<String>(limitId) {
    companion object : EntityClass<String, Limit>(Limits)

    var limitId by Limits.limitId
    var customerHash by Limits.customerHash
    var customerId by Limits.customerId
    var tenderId by Limits.tenderId

    var limitType by Limits.limitType
    var availableLimit by Limits.availableLimit
    var minTransactionAmount by Limits.minTransactionAmount
    var maxTransactionAmount by Limits.maxTransactionAmount
    var utilisedLimit by Limits.utilisedLimit
    var totalLimit by Limits.totalLimit
    var limitStatus by Limits.limitStatus
    var inactiveReason by Limits.inactiveReason
    var lenderId by Limits.lenderId
    var maxInstallmentAmount by Limits.maxInstallmentAmount
    var maxTransactionAmountWithoutDownpayment by Limits.maxTransactionAmountWithoutDownpayment
    var downpaymentType by Limits.downpaymentType
    var minDownpaymentValue by Limits.minDownpaymentValue
    var status by Limits.status
    var createdOn by Limits.createdOn
    var createdBy by Limits.createdBy
    var updatedOn by Limits.updatedOn
    var updatedBy by Limits.updatedBy
}

class TransactionStatusApiCallTracking(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<TransactionStatusApiCallTracking>(TransactionStatusApiCallTrackings)
    var loanTransactionId by TransactionStatusApiCallTrackings.loanTransactionId
    var apiCallTimestamp by TransactionStatusApiCallTrackings.apiCallTimestamp
}