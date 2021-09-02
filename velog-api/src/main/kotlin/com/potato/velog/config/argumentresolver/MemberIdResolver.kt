package com.potato.velog.config.argumentresolver

import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

@Component
class MemberIdResolver : HandlerMethodArgumentResolver {

    override fun supportsParameter(parameter: MethodParameter): Boolean {
        val hasMemberIdAnnotation = parameter.getParameterAnnotation(MemberId::class.java) != null
        val isLongType = parameter.parameterType == Long::class.java
        return hasMemberIdAnnotation.and(isLongType)
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Any? {
        return webRequest.getAttribute("memberId", 0)
    }

}