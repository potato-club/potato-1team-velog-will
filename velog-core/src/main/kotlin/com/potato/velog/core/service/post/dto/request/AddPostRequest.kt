package com.potato.velog.core.service.post.dto.request

import com.potato.velog.core.domain.post.Post
import com.potato.velog.core.domain.post.PostStatus

data class AddPostRequest(
    val title: String,
    val content: String,
    val status: PostStatus
) {

    fun toEntity(memberId: Long): Post {
        return Post(memberId, title, content, status)
    }

}
