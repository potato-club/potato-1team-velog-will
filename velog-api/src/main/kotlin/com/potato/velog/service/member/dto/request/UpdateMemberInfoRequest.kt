package com.potato.velog.service.member.dto.request

data class UpdateMemberInfoRequest(
    val name: String,
    val profileUrl: String,
    val introduction: String
)