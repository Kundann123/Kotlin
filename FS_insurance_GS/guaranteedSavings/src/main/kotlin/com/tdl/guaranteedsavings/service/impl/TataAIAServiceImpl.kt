package com.tdl.guaranteedsavings.service.impl

import com.tdl.guaranteedsavings.config.Configuration
import com.tdl.guaranteedsavings.dto.*
import com.tdl.guaranteedsavings.exception.GSInternalServerException
import com.tdl.guaranteedsavings.plugins.ConfigureClient
import com.tdl.guaranteedsavings.service.TataAIAService
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class TataAIAServiceImpl : TataAIAService {
    private val props = Configuration.env
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    override suspend fun policyGenerate(body: PolicyGenerateDTO): Any {

        val response: HttpResponse
        try {
            response = ConfigureClient.tataAIAClient.post("${props.tataAIABaseUrl}//generatepolicyno/1234567890")
                {
                    setBody(body)
                }
            log.info("Policy Generate Status Code :${response.status}")
            return if (response.status == HttpStatusCode.OK) {
                val policyResponse = response.body() as PolicyGenerateResponse
                policyResponse

            } else {
                log.error(
                    "Policy Number Generate: Error in response body " +
                            "${response.status.value} ${response.status.description}"
                )
                response.body() as PolicyGenerateError
            }
        } catch (e: Exception) {
            log.error("Policy Number Generate: Exception occurred while calling api ${e.stackTraceToString()}")
            throw GSInternalServerException(e.stackTraceToString())
        }

    }

    override suspend fun validateDocument(body: ValidateDocumentDTO): Any {

        val response: HttpResponse
        try {
            response = ConfigureClient.tataAIAClient.post("${props.tataAIABaseUrl}//validatedocument/1234567890")
            {
                setBody(body)
            }
            log.info("Validate Document Status Code :${response.status}")
            return if (response.status == HttpStatusCode.OK) {
                val validateDocumentResponse = response.body() as ValidateDocumentResponse
                validateDocumentResponse

            } else {
                log.error(
                    "Validate Document Error in response body " +
                            "${response.status.value} ${response.status.description}"
                )
                response.body() as ValidateDocumentError
            }
        } catch (e: Exception) {
            log.error("Validate Document: Exception occurred while calling api ${e.stackTraceToString()}")
            throw GSInternalServerException(e.stackTraceToString())
        }

    }

}
