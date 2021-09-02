package com.potato.velog.service.post

import com.potato.velog.core.domain.post.repository.PostProjection
import java.time.LocalDateTime

data class PostPaginationResponse(
    val postId: Long,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,

    val memberName: String,
    val memberProfileUrl: String
) {

    companion object {
        fun of(postProjection: PostProjection): PostPaginationResponse {
            return PostPaginationResponse(
                postProjection.postId,
                postProjection.title,
                postProjection.content,
                postProjection.createdAt,
                postProjection.updatedAt,
                postProjection.memberName,
                postProjection.memberProfileUrl
            )
        }
    }

}
