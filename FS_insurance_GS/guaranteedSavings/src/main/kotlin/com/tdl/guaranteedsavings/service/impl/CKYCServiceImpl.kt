package com.tdl.guaranteedsavings.service.impl

import com.tdl.guaranteedsavings.repository.CKYCRepository
import com.google.gson.Gson
import com.tdl.guaranteedsavings.config.Configuration
import com.tdl.guaranteedsavings.dto.*
import com.tdl.guaranteedsavings.exception.GSInternalServerException
import com.tdl.guaranteedsavings.plugins.ConfigureClient
import com.tdl.guaranteedsavings.service.CKYCService
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class CKYCServiceImpl : CKYCService {
    private val props = Configuration.env
    private val log: Logger = LoggerFactory.getLogger(javaClass)
    private val ckycService = CKYCRepository()
    override suspend fun downloadCKYC(body:DownloadCkycDTO): Any {
        val response: HttpResponse
        try {
            response = ConfigureClient.ckycClient.post("${props.ckycBaseUrl}/LifePlaner/CKYCDownload")
            {
                setBody(body)
            }
            log.info("CKYC Download status code :${response.status}")
            return if (response.status == HttpStatusCode.OK ) {
                response.bodyAsText().let {
                    Gson().fromJson(it.reader(),DownloadCKYCResponseDTO::class.java)
                }
            } else {
                log.error(
                    "CKYC Download: Error in response body " +
                            "${response.status.value} ${response.status.description}"
                )
                response.bodyAsText()
            }
        } catch (e: Exception) {
            log.error("CKYC Download: Exception occurred while calling api ${e.stackTraceToString()}")
            throw GSInternalServerException(e.stackTraceToString())
        }

    }

    override suspend fun searchCKYC(body: Request): Any {
        val response: HttpResponse

        try {
            response = ConfigureClient.ckycClient.post("${props.ckycBaseUrl}/LifePlaner/CKYCSearch")
            {
                setBody(body)
            }
            log.info("CKYC Search status code :${response.status}")
            return if (response.status == HttpStatusCode.OK) {
                val ckycResponse= response.bodyAsText().let {
                    Gson().fromJson(it.reader(), CkycSearchResponse::class.java)
                }
                ckycService.saveCKYCSearchDetails(ckycResponse)
                return ckycResponse

            } else {
                log.error(
                    "CKYC Download: Error in response body " +
                            "${response.status.value} ${response.status.description}"
                )
                response.bodyAsText()
            }
        } catch (e: Exception) {
            log.error("CKYC Download: Exception occurred while calling api ${e.stackTraceToString()}")
            throw GSInternalServerException(e.stackTraceToString())
        }
    }

    override suspend fun saveCKYCSearchResponse(body: CkycSearchResponse) {
        return ckycService.saveCKYCSearchDetails(body)

    }
}
