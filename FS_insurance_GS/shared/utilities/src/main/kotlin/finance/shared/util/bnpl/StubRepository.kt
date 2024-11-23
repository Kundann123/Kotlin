package finance.shared.util.bnpl

import finance.shared.entities.bnpl.schemas.StubsMetadata
import finance.shared.entities.bnpl.schemas.StubsResponseData
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class APIStubbingRepository {



    fun findStubAPIMetadataByAPIURI(apiURI: String, httpMethod: String): StubMetadata? {
        var metadata: StubMetadata? = null

        transaction {
            metadata =
                StubsMetadata.select { (StubsMetadata.apiURI eq apiURI) and (StubsMetadata.httpMethod eq httpMethod) }
                    .map { row ->
                        StubMetadata(
                            apiId = row[StubsMetadata.apiId],
                            stubKeyName = row[StubsMetadata.stubKeyName],
                            stubKeyPosition = row[StubsMetadata.stubKeyPosition],
                            apiURI = row[StubsMetadata.apiURI],
                            httpMethod = row[StubsMetadata.httpMethod]
                        )
                    }.singleOrNull()
        }
        return metadata

    }

    fun findStubResponseByInputKey(key: String, stubbedApiId: Int): StubResponseData? {

        var responseData:StubResponseData? = null
        transaction {
            responseData = StubsResponseData.select { (StubsResponseData.keyValue eq key) and (StubsResponseData.stubbedApiId eq stubbedApiId) }
                .map { row ->
                    StubResponseData(
                        responseId = row[StubsResponseData.responseId],
                        keyValue = row[StubsResponseData.keyValue],
                        responseJson = row[StubsResponseData.responseJson],
                        responseHttpStatus = row[StubsResponseData.responseHttpStatus],
                        stubbedApiId = row[StubsResponseData.stubbedApiId]
                    )
                }.singleOrNull()
        }
        return responseData


    }
}