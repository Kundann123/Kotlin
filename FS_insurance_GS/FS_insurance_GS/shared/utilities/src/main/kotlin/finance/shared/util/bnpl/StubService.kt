package finance.shared.util.bnpl


import com.google.gson.Gson
import com.jayway.jsonpath.JsonPath

import io.ktor.http.*
import io.ktor.server.request.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.ConcurrentHashMap

object TPLStubService {

    private val log: Logger = LoggerFactory.getLogger(javaClass)
    val mutex = Mutex()
    val logger = LoggerFactory.getLogger(javaClass)
    private val stubRepository = APIStubbingRepository()

    var apiMetadata = ConcurrentHashMap<String, StubMetadata?>()
    var responseCache = ConcurrentHashMap<String, Pair<HttpStatusCode, String>>()


    suspend fun getAPIMetaData(uri: String, httpMethod: String): StubMetadata? {

        if (apiMetadata[uri] == null) {
            mutex.withLock() {
                if (apiMetadata[uri] == null) {
                    apiMetadata.put(uri, stubRepository.findStubAPIMetadataByAPIURI(uri, httpMethod)!!)
                }

            }
        }
        return apiMetadata[uri]
    }

    suspend fun getStubResponse(request: ApplicationRequest, requestBody: Any): Pair<HttpStatusCode, String> {

        //get the api stub metadata

        val questionMarkPos = request.uri.indexOf("?")

        var apiURI: String = request.uri
        if (questionMarkPos != -1) {
            apiURI = request.uri.substring(0, questionMarkPos)
        }
        val logTag = "[Stubbed api $apiURI]"
        log.info("$logTag request URI: $apiURI")
        log.info("$logTag Http method: ${request.httpMethod.value}")
        var apiMetadata = getAPIMetaData(apiURI, request.httpMethod.value)

        log.info("$logTag Key: ${apiMetadata?.stubKeyName}")

        when (apiMetadata?.stubKeyPosition) {
            "QueryParam" -> {
                log.info("$logTag Key Position is QueryParam")
                log.debug("$logTag API Key value: ${request.queryParameters[apiMetadata.stubKeyName]!!}")
                if (responseCache[request.queryParameters[apiMetadata.stubKeyName]!!] == null) {

                    responseCache.put(
                        request.queryParameters[apiMetadata.stubKeyName]!!,
                        getStubResponseData(
                            request.queryParameters[apiMetadata.stubKeyName]!!,
                            logTag,
                            apiMetadata.apiId
                        )
                    )

                }

                return responseCache[request.queryParameters[apiMetadata.stubKeyName]!!]!!

            }

            "HttpHeader" -> {
                log.info("$logTag Key Position is HttpHeader")
                log.debug("$logTag API Key value: ${request.headers[apiMetadata.stubKeyName]!!}")
                if (responseCache[request.headers[apiMetadata.stubKeyName]!!] == null) {

                    responseCache.put(
                        request.headers[apiMetadata.stubKeyName]!!,
                        getStubResponseData(
                            request.headers[apiMetadata.stubKeyName]!!,
                            logTag,
                            apiMetadata.apiId
                        )
                    )

                }

                return responseCache[request.headers[apiMetadata.stubKeyName]!!]!!

            }

            "JsonPayload" -> {


                try {
                    log.info("$logTag Key Position is JsonPayload")
                    var lookupValue = ""
                    var jsonPath = "\$['${apiMetadata.stubKeyName}']"
                    when ("$apiURI-${apiMetadata.httpMethod.lowercase()}") {
                        "/api/v1/tender/eligibility-post" -> {


                            val jsonString = Gson().toJson(requestBody)

                            lookupValue = JsonPath.read<String>(jsonString, jsonPath)
                        }
                        else -> {
                            val jsonString = Gson().toJson(requestBody)
                            lookupValue = JsonPath.read(jsonString, jsonPath)
                        }
                    }
                    log.info("$logTag LookUp value: ${lookupValue}")

                    if (responseCache[lookupValue] == null) {
                        responseCache.put(
                            lookupValue,
                            getStubResponseData(
                                lookupValue,
                                logTag,
                                apiMetadata.apiId
                            )
                        )

                    }

                    return responseCache[lookupValue]!!

                } catch (e: Exception) {
                    log.error("$logTag Exception occurred while fetching Stub response: ${e.message}")
                    log.error("$logTag Exception StackTrace: ")
                }
            }
        }

        if (responseCache["defaultresponse"] == null) {

            responseCache.put(
                "defaultresponse",
                Pair(
                    HttpStatusCode.OK,
                    stubRepository.findStubResponseByInputKey("defaultresponse", apiMetadata?.apiId!!)?.responseJson!!,
                )
            )

        }

        return responseCache["defaultresponse"]!!

    }

    private fun getStubResponseData(
        lookupValue: String,
        logTag: String,
        stubbedApiId: Int
    ): Pair<HttpStatusCode, String> {
        var jsonStubResponse: StubResponseData? = null
        try {
            log.info("$logTag LookUp value: ${lookupValue}")
            jsonStubResponse = lookupValue.let { stubRepository.findStubResponseByInputKey(it, stubbedApiId) }

            log.info("$logTag Response json: $jsonStubResponse")
            log.info("$logTag responseJson: ${jsonStubResponse?.responseJson}")
            if (jsonStubResponse != null) {
                return Pair(
                    HttpStatusCode.fromValue(jsonStubResponse.responseHttpStatus),
                    jsonStubResponse.responseJson
                )

            } else {
                log.info("$logTag Stub response for key $lookupValue not found.Returning default response")
                return Pair(
                    HttpStatusCode.OK,
                    stubRepository.findStubResponseByInputKey("defaultresponse", stubbedApiId)?.responseJson!!
                )
            }
        } catch (e: Exception) {
            log.info("$logTag Exception occurred while fetching Stub response: ${e.message}")
            log.debug("$logTag Exception StackTrace: ")
            e.printStackTrace()
        }

        return Pair(
            HttpStatusCode.OK,
            stubRepository.findStubResponseByInputKey("defaultresponse", stubbedApiId)?.responseJson!!,
        )
    }
}