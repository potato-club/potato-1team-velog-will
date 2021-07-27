package com.potato.velog.service.auth.dto.response

import com.potato.velog.core.domain.member.Member

data class MemberInfoResponse(
    val email: String,
    val name: String,
    val profileUrl: String,
    val introduction: String
) {

    companion object {
        fun of(member: Member): MemberInfoResponse {
            return MemberInfoResponse(member.email, member.name, member.profileUrl, member.introduction)
        }
    }

}
