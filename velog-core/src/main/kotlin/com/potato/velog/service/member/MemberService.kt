package com.potato.velog.service.member

import com.potato.velog.domain.member.Member
import com.potato.velog.domain.member.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {

    @Transactional
    fun addMember() {
        memberRepository.save(Member("will.seungho@gmail.com", "will"))
    }

}