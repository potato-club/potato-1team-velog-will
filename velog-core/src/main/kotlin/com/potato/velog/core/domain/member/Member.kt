package com.potato.velog.core.domain.member

import com.potato.velog.core.domain.BaseTimeEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Member(
    var email: String,
    var password: String,
    var name: String,
    var profileUrl: String = "",
    var introduction: String = ""
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
        protected set

}