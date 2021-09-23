package com.potato.velog.service

import com.potato.velog.core.domain.member.Member
import com.potato.velog.core.domain.member.MemberRepository
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired

abstract class MemberSetUpTest {
    @Autowired
    private lateinit var memberRepository: MemberRepository

    protected var memberId: Long = 0

    @BeforeEach
    fun setUpMember() {
        val member = Member(
            email = "will.seungho@gmail.com",
            password = "password",
            name = "will"
        )
        memberId = member.id
        memberRepository.save(member)
    }

    fun cleanup() {
        memberRepository.deleteAll()
    }

}