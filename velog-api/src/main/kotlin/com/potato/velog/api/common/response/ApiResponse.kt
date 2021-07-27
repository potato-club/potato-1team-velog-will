package com.potato.velog.api.common.response

data class ApiResponse<T>(
    val status: String = "",
    val message: String = "",
    val data: T?
) {

    companion object {
        val OK = success("")

        fun <T> success(data: T): ApiResponse<T> {
            return ApiResponse("OK", "", data)
        }

        fun error(code: String, message: String): ApiResponse<Nothing> {
            return ApiResponse(code, message, null)
        }
    }

}