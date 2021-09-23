package com.potato.velog.service.post.dto.request

import com.potato.velog.core.domain.post.Post
import com.potato.velog.core.domain.post.PostStatus

data class AddPostRequest(
    val title: String,
    val content: String,
    val status: PostStatus
) {

    fun toEntity(memberId: Long): Post {
        return Post(
            memberId = memberId,
            title = title,
            content = content,
            status = status
        )
    }

}
