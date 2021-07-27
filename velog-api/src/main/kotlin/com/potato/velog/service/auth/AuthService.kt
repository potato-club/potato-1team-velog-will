package com.potato.velog.service.auth

import com.potato.velog.core.domain.member.MemberRepository
import com.potato.velog.service.auth.dto.request.SignUpRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthService(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder
) {

    @Transactional
    fun signUp(request: SignUpRequest): Long {
        return memberRepository.save(request.toEntity(passwordEncoder)).id
    }

}