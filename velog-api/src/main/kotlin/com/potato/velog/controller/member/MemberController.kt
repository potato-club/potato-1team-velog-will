package com.potato.velog.controller.member

import com.potato.velog.config.argumentresolver.MemberId
import com.potato.velog.config.interceptor.Auth
import com.potato.velog.controller.dto.ApiResponse
import com.potato.velog.service.auth.dto.response.MemberInfoResponse
import com.potato.velog.service.member.MemberService
import com.potato.velog.service.member.dto.request.UpdateMemberInfoRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    private val memberService: MemberService
) {

    @Auth
    @GetMapping("/api/v1/member")
    fun getMyMemberInfo(
        @MemberId memberId: Long
    ): ApiResponse<MemberInfoResponse> {
        return ApiResponse.success(memberService.getMemberInfo(memberId))
    }

    @Auth
    @PutMapping("/api/v1/member")
    fun updateMyMemberInfo(
        @RequestBody request: UpdateMemberInfoRequest,
        @MemberId memberId: Long
    ): ApiResponse<MemberInfoResponse> {
        return ApiResponse.success(memberService.updateMemberInfo(request, memberId))
    }

}