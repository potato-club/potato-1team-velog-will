package com.potato.velog.service.post

import com.potato.velog.service.post.dto.request.AddPostRequest
import com.potato.velog.service.post.dto.response.PostInfoResponse
import com.potato.velog.core.domain.post.repository.PostPaginationDto
import com.potato.velog.service.post.dto.request.RetrievePostsPagination
import com.potato.velog.core.domain.post.PostRepository
import com.potato.velog.service.post.dto.request.UpdatePostRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService(
    private val postRepository: PostRepository
) {

    @Transactional
    fun addPost(request: AddPostRequest, memberId: Long): PostInfoResponse {
        return PostInfoResponse.of(postRepository.save(request.toEntity(memberId)))
    }

    @Transactional(readOnly = true)
    fun retrievePostsPagination(request: RetrievePostsPagination): List<PostPaginationDto> {
        return postRepository.findWithPagination(request.lastPostId, request.title, request.size)
    }

    @Transactional
    fun updatePost(postId: Long, request: UpdatePostRequest, memberId: Long): PostInfoResponse {
        val post = PostServiceUtils.findPostByIdAndMemberId(postRepository, postId, memberId)
        post.update(request.title, request.content, request.status)
        return PostInfoResponse.of(post)
    }

    @Transactional
    fun deletePost(postId: Long, memberId: Long) {
        val post = PostServiceUtils.findPostByIdAndMemberId(postRepository, postId, memberId)
        post.delete()
    }

}