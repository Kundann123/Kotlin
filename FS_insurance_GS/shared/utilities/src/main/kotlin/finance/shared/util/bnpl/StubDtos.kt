package finance.shared.util.bnpl

data class StubMetadata(
    val apiId: Int,
    val stubKeyName: String,
    val stubKeyPosition: String,
    val apiURI: String,
    val httpMethod: String,

    )

data class StubResponseData(

    val responseId: Int,
    val keyValue: String,
    val responseJson: String,
    val responseHttpStatus: Int,
    val stubbedApiId: Int
)