package finance.shared.util

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import java.util.*

private data class APIResponse<T : Any?>(
    val path: String, val timestamp: Date, val status: Status, val message: T, val errorMessage: String? = null
)

private data class Status(val code: Int, val displayMessage: String)

suspend fun <T : Any> ApplicationCall.fireHttpResponse(statusCode: HttpStatusCode, message: T) {
    respond(
        HttpStatusCode.OK,
        APIResponse(request.path(), Date(), Status(statusCode.value, statusCode.description), message)
    )
}

suspend fun <T : Any?> ApplicationCall.fireHttpErrorResponse(
    statusCode: HttpStatusCode,
    errorMessage: String,
    message: T
) {
    respond(
        statusCode,
        APIResponse(
            request.path(),
            Date(),
            Status(statusCode.value, errorMessage),
            message
        )
    )
}
