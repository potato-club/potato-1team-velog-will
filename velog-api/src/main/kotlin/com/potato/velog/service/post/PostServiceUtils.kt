package com.potato.velog.service.post

import com.potato.velog.core.domain.post.Post
import com.potato.velog.core.domain.post.PostRepository
import com.potato.velog.core.exception.NotFoundException

object PostServiceUtils {

    fun findPostByIdAndMemberId(postRepository: PostRepository, postId: Long, memberId: Long): Post {
        return postRepository.findPostByIdAndMemberId(postId, memberId)
            ?: throw NotFoundException("존재하지 않는 게시물 $postId 입니다")
    }

}
