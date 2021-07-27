package com.potato.velog.config.session

import java.io.Serializable

data class MemberSession(
    val memberId: Long
): Serializable