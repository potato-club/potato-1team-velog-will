package com.potato.velog.controller

import com.potato.velog.controller.dto.ApiResponse
import com.potato.velog.core.exception.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerAdvice(
) {

    private val logger: Logger = LoggerFactory.getLogger(ControllerAdvice::class.java)

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException::class)
    private fun handleValidationException(e: ValidationException): ApiResponse<Nothing> {
        logger.error("$e", e.message)
        return ApiResponse.error("VALIDATION_EXCEPTION", e.message)
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException::class)
    private fun handleNotFoundException(e: NotFoundException): ApiResponse<Nothing> {
        logger.error("$e", e.message)
        return ApiResponse.error("NOT_FOUND_EXCEPTION", e.message)
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ConflictException::class)
    private fun handleConflictException(e: ConflictException): ApiResponse<Nothing> {
        logger.error("$e", e.message)
        return ApiResponse.error("CONFLICT_EXCEPTION", e.message)
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnAuthorizedException::class)
    private fun handleUnAuthorizedException(e: UnAuthorizedException): ApiResponse<Nothing> {
        logger.error("$e", e.message)
        return ApiResponse.error("UNAUTHORIZED_EXCEPTION", "토큰이 만료되었습니다. 다시 로그인 해주세요")
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(ServiceUnavailableException::class)
    private fun handleServiceUnavailableException(e: ServiceUnavailableException): ApiResponse<Nothing> {
        logger.error("$e", e.message)
        return ApiResponse.error("SERVICE_UNAVAILABLE_EXCEPTION", e.message)
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException::class)
    private fun handleException(e: RuntimeException): ApiResponse<Nothing> {
        logger.error("$e", e.message)
        return ApiResponse.error("INTERNAL_SERVER_EXCEPTION", e.message ?: "서버 내부에서 에러가 발생하였습니다.")
    }

}