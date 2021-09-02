package com.potato.velog.core.domain.member.repository

import com.potato.velog.core.domain.member.Member

interface MemberRepositoryCustom {

    fun findMemberById(memberId: Long): Member?

}