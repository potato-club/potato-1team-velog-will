package com.potato.velog.domain.member

import org.springframework.data.repository.CrudRepository

interface MemberRepository : CrudRepository<Member, String> {

    fun findByName(name: String): Member?

}

