package com.tdl.guaranteedsavings.plugins

import com.tdl.guaranteedsavings.utils.Constants
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.headers
import io.ktor.serialization.gson.gson

object ConfigureClient {
    val ckycClient = HttpClient(CIO) {
        defaultRequest {
            headers {
                append(Constants.CONTENT_TYPE, Constants.JSON_CONTENT)
            }
        }
        install(ContentNegotiation) {
            gson()
        }
    }

    val tataAIAClient = HttpClient(CIO){
        defaultRequest {
            headers {
                append(Constants.CONTENT_TYPE, Constants.JSON_CONTENT)
            }
        }
        install(ContentNegotiation) {
            gson()
        }
    }
}
