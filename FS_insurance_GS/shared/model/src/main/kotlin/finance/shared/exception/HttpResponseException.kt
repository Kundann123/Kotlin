package finance.shared.exception

import io.ktor.http.*

class HttpResponseException(
    val statusCode: HttpStatusCode,
    val displayMessage: String,
    val data: Any?) : Exception()
