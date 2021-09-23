package com.potato.velog.service.auth

import com.potato.velog.core.domain.member.Member
import com.potato.velog.service.auth.dto.request.SignUpRequest
import com.potato.velog.core.domain.member.MemberRepository
import com.potato.velog.core.exception.ConflictException
import com.potato.velog.core.exception.NotFoundException
import com.potato.velog.service.auth.dto.request.LoginRequest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootTest
internal class AuthServiceTest(
    @Autowired
    private val authService: AuthService,

    @Autowired
    private val memberRepository: MemberRepository,

    @Autowired
    private val passwordEncoder: PasswordEncoder
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

    @Test
    fun 회원가입시_이미_존재하는_이메일인경우_에러_발생() {
        // given
        val email = "will.seungho@gmail.com"
        memberRepository.save(
            Member(
                email = email,
                password = "password",
                name = "name"
            )
        )

        val request = SignUpRequest(email, "password", "another name")

        // when & then
        assertThatThrownBy { authService.signUp(request) }.isInstanceOf(ConflictException::class.java)
    }

    @Test
    fun 이메일과_비밀번호가_일치하면_로그인이_성공한다() {
        // given
        val email = "will.seungho@gmail.com"
        val password = "password"
        val member = Member(
            email = email,
            password = passwordEncoder.encode(password),
            name = "name"
        )
        memberRepository.save(member)

        val request = LoginRequest(email, password)

        // when
        val memberId = authService.login(request)

        // then
        assertThat(memberId).isEqualTo(member.id)
    }

    @Test
    fun 로그인시_존재하지_않는_이메일이면_에러_발생() {
        // given
        val request = LoginRequest("will.seungho@gmail.com", "anotherPassword")

        // when & then
        assertThatThrownBy { authService.login(request) }.isInstanceOf(NotFoundException::class.java)
    }

    @Test
    fun 로그인시_비밀번호가_일치하지_않으면_에러_발생() {
        // given
        val email = "will.seungho@gmail.com"
        val member = Member(
            email = email,
            password = "password",
            name = "name"
        )
        memberRepository.save(member)

        val request = LoginRequest(email, "anotherPassword")

        // when & then
        assertThatThrownBy { authService.login(request) }.isInstanceOf(NotFoundException::class.java)
    }

}