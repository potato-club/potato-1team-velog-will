package com.potato.velog.web.member

import com.potato.velog.service.member.MemberService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    private val memberService: MemberService
) {

    @GetMapping("/test")
    fun addMember(): String {
        memberService.addMember()
        return "OK"
    }

}