package com.potato.velog.web

data class ApiResponse<T>(
    val code: String,
    val message: String,
    val data: T
) {

    companion object {
        val OK = success("OK")

        fun <T> success(data: T): ApiResponse<T> {
            return ApiResponse("", "", data)
        }
    }

}