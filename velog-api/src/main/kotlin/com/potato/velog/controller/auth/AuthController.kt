package com.potato.velog.controller.auth

import com.potato.velog.config.interceptor.Auth
import com.potato.velog.config.session.SessionConstants
import com.potato.velog.common.dto.ApiResponse
import com.potato.velog.service.auth.AuthService
import com.potato.velog.service.auth.dto.request.LoginRequest
import com.potato.velog.service.auth.dto.request.SignUpRequest
import com.potato.velog.service.auth.dto.response.LoginResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpSession

@RestController
class AuthController(
        private val authService: AuthService,
        private val httpSession: HttpSession
) {

    @PostMapping("/api/v1/signup")
    fun signUp(
            @RequestBody request: SignUpRequest
    ): ApiResponse<LoginResponse> {
        val memberId = authService.signUp(request)
        httpSession.setAttribute(SessionConstants.MEMBER_SESSION, memberId)
        return ApiResponse.success(LoginResponse(httpSession.id))
    }

    @PostMapping("/api/v1/login")
    fun login(
            @RequestBody request: LoginRequest
    ): ApiResponse<LoginResponse> {
        val memberId = authService.login(request)
        httpSession.setAttribute(SessionConstants.MEMBER_SESSION, memberId)
        return ApiResponse.success(LoginResponse(httpSession.id))
    }

    @Auth
    @PostMapping("/api/v1/logout")
    fun logout(): ApiResponse<String> {
        httpSession.removeAttribute(SessionConstants.MEMBER_SESSION)
        return ApiResponse.OK
    }

}