package com.potato.velog.controller.auth

import com.potato.velog.config.session.MemberSession
import com.potato.velog.controller.dto.ApiResponse
import com.potato.velog.service.auth.AuthService
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
    fun singUp(
        @RequestBody request: SignUpRequest
    ): ApiResponse<LoginResponse> {
        val memberId = authService.signUp(request)
        httpSession.setAttribute("MEMBER_SESSION", MemberSession(memberId))
        return ApiResponse.success(LoginResponse(httpSession.id))
    }

    @PostMapping("/api/v1/logout")
    fun logout(): ApiResponse<String> {
        httpSession.invalidate()
        return ApiResponse.OK
    }

}