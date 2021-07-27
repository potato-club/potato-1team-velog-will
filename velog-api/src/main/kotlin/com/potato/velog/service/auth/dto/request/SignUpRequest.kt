package com.potato.velog.service.auth.dto.request

import com.potato.velog.core.domain.member.Member
import org.springframework.security.crypto.password.PasswordEncoder

data class SignUpRequest(
    val email: String,
    val password: String,
    val name: String
) {

    fun toEntity(passwordEncoder: PasswordEncoder): Member {
        return Member(email, passwordEncoder.encode(password), name)
    }

}