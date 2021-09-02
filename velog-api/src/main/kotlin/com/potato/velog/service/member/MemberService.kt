package com.potato.velog.service.member

import com.potato.velog.core.domain.member.MemberRepository
import com.potato.velog.core.exception.NotFoundException
import com.potato.velog.service.auth.dto.response.MemberInfoResponse
import com.potato.velog.service.member.dto.request.UpdateMemberInfoRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {

    @Transactional(readOnly = true)
    fun getMemberInfo(memberId: Long): MemberInfoResponse {
        val member = memberRepository.findMemberById(memberId)
            ?: throw NotFoundException("해당하는 멤버는 존재하지 않습니다 ($memberId)")
        return MemberInfoResponse.of(member)
    }

    @Transactional
    fun updateMemberInfo(request: UpdateMemberInfoRequest, memberId: Long): MemberInfoResponse {
        val member = memberRepository.findMemberById(memberId)
            ?: throw NotFoundException("해당하는 멤버는 존재하지 않습니다 ($memberId)")
        member.update(request.name, request.profileUrl, request.introduction)
        return MemberInfoResponse.of(member)
    }

}