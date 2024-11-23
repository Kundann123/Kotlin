package finance.shared.entities.bnpl.schemas

import org.jetbrains.exposed.sql.Table

object StubsMetadata : Table("stubbed_api_metadata") {

    val apiId = integer("api_id").autoIncrement()
    val stubKeyName = varchar("stub_key_name", 255)
    val stubKeyPosition = varchar("stub_key_position", 255)
    val apiURI = varchar("api_uri", 255)
    val httpMethod = varchar("http_method", 255)
    override val primaryKey = PrimaryKey(apiId)
}

object StubsResponseData : Table("stub_response_data") {

    val responseId = integer("response_id").autoIncrement()
    val keyValue = varchar("key_value", 255)
    val responseJson = text("response_json")
    val responseHttpStatus = integer("response_http_status")
    val stubbedApiId = reference("stubbed_api_id",StubsMetadata.apiId)
    override val primaryKey = PrimaryKey(responseId)
}