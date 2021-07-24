package com.potato.velog.domain.member

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemberRepositoryTest(
    @Autowired
    private val memberRepository: MemberRepository
) {

    @AfterEach
    fun cleanUp() {
        memberRepository.deleteAll()
    }

    @Test
    fun save_test() {
        // when
        memberRepository.save(Member("will.seungho@gmail.com", "will"))

        // then
        val member = memberRepository.findByName("will")
        assertThat(member?.email).isEqualTo("will.seungho@gmail.com")
    }

}