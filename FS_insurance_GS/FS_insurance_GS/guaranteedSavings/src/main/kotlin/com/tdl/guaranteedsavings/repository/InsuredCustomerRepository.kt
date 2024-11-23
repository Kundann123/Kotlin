package com.tdl.guaranteedsavings.repository

import com.tdl.guaranteedsavings.config.DBConfig
import com.tdl.guaranteedsavings.dto.InsuredCustomerAddressDTO
import com.tdl.guaranteedsavings.entities.InsuredCustomerAddresses
import com.tdl.guaranteedsavings.entities.InsuredCustomers
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.insert
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class InsuredCustomerRepository {
    private val databaseConnection = DBConfig.getDatabase()
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    fun saveInsuredCustomer(body: InsuredCustomerAddressDTO): Any {
        var noOfRecordsAffected = 0
        val transaction = databaseConnection.transactionManager.newTransaction(
            isolation = TransactionIsolation.READ_COMMITTED
        )
        try {
            databaseConnection.insert(InsuredCustomerAddresses){
                set(it.addId, body.addId)
                set(it.insuredId, body.insuredCustomer.insuredId)
                set(it.addrFirstLine, body.addrFirstLine)
                set(it.addrSecondLine, body.addrSecondLine)
                set(it.city, body.city)
                set(it.state, body.state)
                set(it.pinCode, body.pinCode)
                set(it.effectiveFrom, body.effectiveFrom)
                set(it.createdByUser, body.createdByUser)
                set(it.createdByDate, body.createdByDate)
                set(it.modifiedByUser, body.modifiedByUser)
                set(it.modifiedByDate, body.modifiedByDate)
            }.apply { noOfRecordsAffected += this }
            databaseConnection.insert(InsuredCustomers){
                set(it.insuredId, body.insuredCustomer.insuredId)
                set(it.firstName, body.insuredCustomer.firstName)
                set(it.lastName, body.insuredCustomer.lastName)
                set(it.phoneNumber, body.insuredCustomer.phoneNumber)
                set(it.email, body.insuredCustomer.email)
                set(it.dob, body.insuredCustomer.dob)
                set(it.gender, body.insuredCustomer.gender)
                set(it.panNumber, body.insuredCustomer.panNumber)
                set(it.panName, body.insuredCustomer.panName)
                set(it.incomeDetail, body.insuredCustomer.incomeDetail)
                set(it.height, body.insuredCustomer.height)
                set(it.weight, body.insuredCustomer.weight)
                set(it.relationshipWithProposer, body.insuredCustomer.relationshipWithProposer)
                set(it.createdByUser, body.insuredCustomer.createdByUser)
                set(it.createdByDate, body.insuredCustomer.createdByDate)
                set(it.modifiedByUser, body.insuredCustomer.modifiedByUser)
                set(it.modifiedByDate, body.insuredCustomer.modifiedByDate)

            }.apply { noOfRecordsAffected += this }
            transaction.commit()
            log.info("Insured Customer :Transaction commit done")
        }catch (e:Exception){
            noOfRecordsAffected = 0
            transaction.rollback()
            log.info("Insured Customer :Transaction Closed")
            log.info("Insured Customer : Exception occurred while inserting into database ${e.stackTraceToString()}")
        }finally {
            transaction.close()
            log.info("Insured Customer :Transaction Closed")
        }
        return noOfRecordsAffected
    }
}