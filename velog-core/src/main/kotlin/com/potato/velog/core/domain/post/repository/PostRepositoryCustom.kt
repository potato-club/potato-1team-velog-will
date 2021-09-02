package com.potato.velog.core.domain.post.repository

import com.potato.velog.core.domain.post.Post

interface PostRepositoryCustom {

    fun findWithPagination(lastPostId: Long?, title: String?, size: Long): List<PostProjection>

    fun findPostByIdAndMemberId(postId: Long, memberId: Long): Post?

}