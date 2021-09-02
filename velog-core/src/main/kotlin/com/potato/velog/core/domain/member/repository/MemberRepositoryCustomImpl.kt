package com.potato.velog.core.domain.member.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.potato.velog.core.domain.member.Member
import com.potato.velog.core.domain.member.QMember.member

class MemberRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
) : MemberRepositoryCustom {

    override fun findMemberById(memberId: Long): Member? {
        return queryFactory.selectFrom(member)
            .where(
                member.id.eq(memberId)
            )
            .fetchOne()
    }

}