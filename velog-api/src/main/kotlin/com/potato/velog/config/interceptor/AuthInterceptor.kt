package com.potato.velog.config.interceptor

import com.potato.velog.config.session.SessionConstants
import com.potato.velog.core.exception.UnAuthorizedException
import org.springframework.http.HttpHeaders
import org.springframework.session.Session
import org.springframework.session.SessionRepository
import org.springframework.stereotype.Component
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
class AuthInterceptor(
    private val sessionRepository: SessionRepository<out Session?>
) : HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if (handler !is HandlerMethod) {
            return true
        }
        handler.getMethodAnnotation(Auth::class.java) ?: return true

        val sessionId = request.getHeader(HttpHeaders.AUTHORIZATION).split(PREFIX)[1]
        val session = sessionRepository.findById(sessionId)
            ?: throw UnAuthorizedException("세션이 만료되었습니다. 다시 로그인해주세요")
        request.setAttribute("memberId", session.getAttribute(SessionConstants.MEMBER_SESSION))
        return true
    }

    companion object {
        private const val PREFIX = "Bearer "
    }

}