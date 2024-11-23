package com.tdl.guaranteedsavings.service.impl

import com.google.gson.FieldNamingPolicy
import com.tdl.guaranteedsavings.config.Configuration
import com.tdl.guaranteedsavings.dto.GeneratedResponse
import com.tdl.guaranteedsavings.dto.GetInfoResponseDTO
import com.tdl.guaranteedsavings.dto.PolicyGenerateDTOMOCK
import com.tdl.guaranteedsavings.plugins.ConfigureClient
import com.tdl.guaranteedsavings.service.PolicyGeneratorService
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.gson.*


class PolicyGeneratorImpl : PolicyGeneratorService {
    private val ref = Configuration.env
    override suspend fun generatePolicyNumber(body: PolicyGenerateDTOMOCK): Any {
        val response: HttpResponse =
            ConfigureClient.tataAIAClient.post("${ref.practice}/api/v1/integration/gs/generatepolicyno") {
                setBody(body)

            }
        println("Policy Generate Status Code :${response.status}")
        return if (response.status == HttpStatusCode.OK) {
            val generatedPolicyResponse = response.body() as GeneratedResponse
            generatedPolicyResponse
        } else {
        }

    }

    override suspend fun getInformation(): Any {
        val client= HttpClient(CIO){
            install(ContentNegotiation) {
                gson{
                    setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                }
            }
        }
        val response:HttpResponse =client.get("https://mocki.io/v1/bcce1ea4-c877-4e7d-9c17-7511b7810a29")
        println(response)
        return response.body() as GetInfoResponseDTO
    }

}