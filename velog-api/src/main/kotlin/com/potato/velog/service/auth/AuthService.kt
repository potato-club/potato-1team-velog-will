package com.potato.velog.service.auth

import com.potato.velog.core.domain.member.MemberRepository
import com.potato.velog.core.exception.NotFoundException
import com.potato.velog.service.auth.dto.request.LoginRequest
import com.potato.velog.service.auth.dto.request.SignUpRequest
import com.potato.velog.service.member.MemberServiceUtils
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
        MemberServiceUtils.validateNotExistEmail(memberRepository, request.email)
        return memberRepository.save(request.toEntity(passwordEncoder)).id
    }

    @Transactional(readOnly = true)
    fun login(request: LoginRequest): Long {
        val member = MemberServiceUtils.findMemberByEmail(memberRepository, request.email)
        if (!passwordEncoder.matches(request.password, member.password)) {
            throw NotFoundException("비밀번호가 일치하지 않습니다")
        }
        return member.id
    }

}