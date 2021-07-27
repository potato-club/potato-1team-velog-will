package com.potato.velog.service.auth

import com.potato.velog.service.auth.dto.request.SignUpRequest
import com.potato.velog.core.domain.member.MemberRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class AuthServiceTest(
    @Autowired
    private val authService: AuthService,

    @Autowired
    private val memberRepository: MemberRepository
) {

    @AfterEach
    fun cleanUp() {
        memberRepository.deleteAll()
    }

    @Test
    fun 새로운_유저가_회원가입_한다() {
        // given
        val email = "will.seungho@gmail.com"
        val name = "will"
        val password = "password"

        val request = SignUpRequest(email, password, name)

        // when
        authService.signUp(request)

        // then
        val members = memberRepository.findAll()
        assertThat(members).hasSize(1)
        assertThat(members[0].email).isEqualTo(email)
        assertThat(members[0].name).isEqualTo(name)
        assertThat(members[0].password).isNotEqualTo(password)
    }

}