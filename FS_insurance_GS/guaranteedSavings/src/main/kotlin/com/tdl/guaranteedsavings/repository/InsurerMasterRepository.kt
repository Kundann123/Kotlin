package com.tdl.guaranteedsavings.repository

import com.tdl.guaranteedsavings.entities.InsurancePolicies
import InsurerMasters
import com.tdl.guaranteedsavings.config.DBConfig
import com.tdl.guaranteedsavings.dto.InsurerMasterDTO
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.insert
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class InsurerMasterRepository {

    private val databaseConnection = DBConfig.getDatabase()
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    fun saveInsurerWithInsurance(insurerInfo: InsurerMasterDTO): Any {
        var noOfRecordsAffected = 0
        val transaction = databaseConnection.transactionManager.newTransaction(
            isolation = TransactionIsolation.READ_COMMITTED )
            try{
                databaseConnection.insert(InsurerMasters){
                    set(it.insurerId,insurerInfo.insurerId)
                    set(it.insurerName,insurerInfo.insurerName)
                    set(it.insurerDesc,insurerInfo.insurerDesc)
                    set(it.agentCode,insurerInfo.agentCode)
                    set(it.activeFlag,insurerInfo.activeFlag)
                    set(it.createdByDate,insurerInfo.createdByDate)
                    set(it.createdByUser,insurerInfo.createdByUser)
                    set(it.modifiedByDate,insurerInfo.modifiedByDate)
                    set(it.modifiedByUser,insurerInfo.modifiedByUser)
                }.apply { noOfRecordsAffected + this }
                databaseConnection.insert(InsurancePolicies){
                    set(it.id,insurerInfo.insurancePolicy.id)
                    set(it.applicationNo,insurerInfo.insurancePolicy.applicationNo)
                    set(it.basePremiumAmount,insurerInfo.insurancePolicy.basePremiumAmount)
                    set(it.certificateNumber,insurerInfo.insurancePolicy.certificateNumber)
                    set(it.cgst,insurerInfo.insurancePolicy.cgst)
                    set(it.customerHash,insurerInfo.insurancePolicy.customerHash)
                    set(it.igst,insurerInfo.insurancePolicy.igst)
                    set(it.inceptionDate,insurerInfo.insurancePolicy.inceptionDate)
                    set(it.incomeDuration,insurerInfo.insurancePolicy.incomeDuration)
                    set(it.incomeFrequency,insurerInfo.insurancePolicy.incomeFrequency)
                    set(it.incomeType,insurerInfo.insurancePolicy.incomeType)
                    set(it.insurancePolicyId,insurerInfo.insurancePolicy.insurancePolicyId)
                    set(it.insuredId,insurerInfo.insurancePolicy.insurerId)
                    set(it.investmentFrequency,insurerInfo.insurancePolicy.investmentFrequency)
                    set(it.isIntraState,insurerInfo.insurancePolicy.isIntraState)
                    set(it.isSmoker,insurerInfo.insurancePolicy.isIntraState)
                    set(it.otp,insurerInfo.insurancePolicy.otp)
                    set(it.otpRefid,insurerInfo.insurancePolicy.otpRefid)
                    set(it.paymentMode,insurerInfo.insurancePolicy.paymentMode)
                    set(it.planId,insurerInfo.insurancePolicy.planId)
                    set(it.policyActivated,insurerInfo.insurancePolicy.policyActivated)
                    set(it.policyNumber,insurerInfo.insurancePolicy.policyNumber)
                    set(it.policyEnddate,insurerInfo.insurancePolicy.policyEnddate)
                    set(it.policyPayTerm,insurerInfo.insurancePolicy.policyPayTerm)
                    set(it.policyPdfUrl,insurerInfo.insurancePolicy.policyPdfUrl)
                    set(it.policyStartDate,insurerInfo.insurancePolicy.policyStartDate)
                    set(it.policyStatus,insurerInfo.insurancePolicy.policyStatus)
                    set(it.policyTerm,insurerInfo.insurancePolicy.policyTerm)
                    set(it.sgst,insurerInfo.insurancePolicy.sgst)
                    set(it.sumAssuredAmount,insurerInfo.insurancePolicy.sumAssuredAmount)
                    set(it.tataDiscount,insurerInfo.insurancePolicy.tataDiscount)
                    set(it.taxAmount,insurerInfo.insurancePolicy.taxAmount)
                    set(it.remark,insurerInfo.insurancePolicy.remark)
                    set(it.createdByUser,insurerInfo.insurancePolicy.createdByUser)
                    set(it.createdByDate,insurerInfo.insurancePolicy.createdByDate)
                    set(it.modifiedByUser,insurerInfo.insurancePolicy.modifiedByUser)
                    set(it.modifiedByDate,insurerInfo.insurancePolicy.modifiedByDate)
                }.apply { noOfRecordsAffected + this }
                transaction.commit()
                log.info("Insurance Policy: Transaction commit done")

        }catch (e:Exception) {
                noOfRecordsAffected = 0
                transaction.rollback()
                log.info("Insurance Policy: Transaction Closed")
            }finally {
                transaction.close()
                log.info("Transaction Closed")

            }
        return noOfRecordsAffected


        }
    }
