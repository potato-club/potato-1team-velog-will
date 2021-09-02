package com.potato.velog.core.domain.member

import com.potato.velog.core.domain.member.repository.MemberRepositoryCustom
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>, MemberRepositoryCustom {

    fun findByEmail(email: String): Member?

}
