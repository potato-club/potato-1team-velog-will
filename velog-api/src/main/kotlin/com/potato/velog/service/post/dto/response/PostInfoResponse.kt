package com.potato.velog.service.post.dto.response

import com.potato.velog.core.domain.post.Post
import com.potato.velog.core.domain.post.PostStatus

data class PostInfoResponse(
    val postId: Long,
    val title: String,
    val content: String,
    val status: PostStatus
) {

    companion object {
        fun of(post: Post): PostInfoResponse {
            return PostInfoResponse(post.id, post.title, post.content, post.status)
        }
    }

}
