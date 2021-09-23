package com.potato.velog.service.member

import com.potato.velog.core.domain.member.Member
import com.potato.velog.core.domain.member.MemberRepository
import com.potato.velog.service.member.dto.request.UpdateMemberInfoRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class MemberServiceTest(
    @Autowired
    private val memberService: MemberService,

    @Autowired
    private val memberRepository: MemberRepository
) {

    @AfterEach
    fun cleanUp() {
        memberRepository.deleteAll()
    }

    @Test
    fun 멤버_정보를_수정한다() {
        // given
        val member = memberRepository.save(
            Member(
                email = "will.seungho@gmail.com",
                password = "passsword",
                name = "will"
            )
        )

        val request = UpdateMemberInfoRequest("willlll", "https://profile.com", "윌 입니다")

        // when
        memberService.updateMemberInfo(request, member.id)

        // then
        val members = memberRepository.findAll()
        assertThat(members).hasSize(1)
        assertThat(members[0].name).isEqualTo(request.name)
        assertThat(members[0].profileUrl).isEqualTo(request.profileUrl)
        assertThat(members[0].introduction).isEqualTo(request.introduction)
    }

}