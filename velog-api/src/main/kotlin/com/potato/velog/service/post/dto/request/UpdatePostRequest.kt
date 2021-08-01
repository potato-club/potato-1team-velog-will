package com.potato.velog.service.post.dto.request

import com.potato.velog.core.domain.post.PostStatus

data class UpdatePostRequest(
    val title: String,
    val content: String,
    val status: PostStatus
)