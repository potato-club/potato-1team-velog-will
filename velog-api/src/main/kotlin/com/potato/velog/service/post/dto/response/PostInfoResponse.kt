package com.potato.velog.service.post.dto.response

import com.potato.velog.controller.dto.BaseTimeResponse
import com.potato.velog.core.domain.post.Post
import com.potato.velog.core.domain.post.PostStatus

data class PostInfoResponse(
        val postId: Long,
        val title: String,
        val content: String,
        val status: PostStatus
) : BaseTimeResponse() {

    companion object {
        fun of(post: Post): PostInfoResponse {
            val response = PostInfoResponse(post.id, post.title, post.content, post.status)
            response.setBaseTime(post)
            return response
        }
    }

}
