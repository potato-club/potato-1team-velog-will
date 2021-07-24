package com.potato.velog.domain.member

import com.potato.velog.domain.BaseTimeEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "member")
class Member(
    val email: String,
    var name: String,
    var profileUrl: String = ""
) : BaseTimeEntity() {

    @Id
    lateinit var id: String
        private set

}