package com.potato.velog.core.domain.post.repository

import com.querydsl.core.annotations.QueryProjection
import java.time.LocalDateTime

class PostProjection @QueryProjection constructor(
    val postId: Long,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,

    val memberName: String,
    val memberProfileUrl: String
)