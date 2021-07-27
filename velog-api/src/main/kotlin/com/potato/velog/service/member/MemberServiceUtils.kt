package com.potato.velog.service.member

import com.potato.velog.core.domain.member.Member
import com.potato.velog.core.domain.member.MemberRepository
import com.potato.velog.core.exception.ConflictException
import com.potato.velog.core.exception.NotFoundException

object MemberServiceUtils {

    fun findMemberByEmail(memberRepository: MemberRepository, email: String): Member {
        return memberRepository.findByEmail(email)
            ?: throw NotFoundException("해당하는 이메일($email)을 가진 사용자는 존재하지 않습니다.")
    }

    fun validateNotExistEmail(memberRepository: MemberRepository, email: String) {
        val member = memberRepository.findByEmail(email)
        member?.let { throw ConflictException("이미 존재하는 이메일($email) 입니다") }
    }

}
