package com.jhonjto.co.valid.utils

import com.jhonjto.co.data.common.Resource
import retrofit2.HttpException
import java.net.SocketTimeoutException

/**
 * Created by jhon on 8/05/2020
 */
enum class ErrorCodes(val code: Int) {
    SocketTimeOut(-1)
}

object Error {
    const val invalid_service = "Invalid service - This service does not exist"
    const val invalid_method = "Invalid Method - No method with that name in this package"
    const val authentication_failed = "Authentication Failed - You do not have permissions to access the service"
    const val invalid_format = "Invalid format - This service doesn't exist in that format"
    const val invalid_parameters = "Invalid parameters - Your request is missing a required parameter"
    const val invalid_resource = "Invalid resource specified"
    const val operation_failed = "Operation failed - Something else went wrong"
    const val invalid_session = "Invalid session key - Please re-authenticate"
    const val invalid_api = "Invalid API key - You must be granted a valid key by last.fm"
    const val service_offline = "Service Offline - This service is temporarily offline. Try again later."
    const val invalid_method_signature = "Invalid method signature supplied"
    const val there_was_temporary_error = "There was a temporary error processing your request. Please try again"
    const val suspended_api = "Suspended API key - Access for your account has been suspended, please contact Last.fm"
    const val rate_limit_exceeded = "Rate limit exceeded - Your IP has made too many requests in a short period"
}

object CodeError {
    const val UNAUTHORIZED = 401
    const val NOT_FOUND = 404
}

open class ResponseHandler {
    fun <T : Any> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T : Any> handleException(e: Exception): Resource<T> {
        return when (e) {
            is HttpException -> Resource.error(
                getErrorMessage(e.code()),
                null
            )
            is SocketTimeoutException -> Resource.error(
                getErrorMessage(ErrorCodes.SocketTimeOut.code),
                null
            )
            else -> Resource.error(
                getErrorMessage(Int.MAX_VALUE),
                null
            )
        }
    }

    private fun getErrorMessage(code: Int): String {
        return when (code) {
            ErrorCodes.SocketTimeOut.code -> Error.there_was_temporary_error
            CodeError.UNAUTHORIZED -> Error.authentication_failed
            CodeError.NOT_FOUND -> Error.invalid_parameters
            else -> Error.invalid_api
        }
    }
}