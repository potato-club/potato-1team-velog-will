package com.potato.velog.controller.post

import com.potato.velog.config.argumentresolver.MemberId
import com.potato.velog.config.interceptor.Auth
import com.potato.velog.controller.dto.ApiResponse
import com.potato.velog.service.post.PostService
import com.potato.velog.service.post.dto.request.AddPostRequest
import com.potato.velog.service.post.PostPaginationResponse
import com.potato.velog.service.post.dto.request.RetrievePostsPagination
import com.potato.velog.service.post.dto.request.UpdatePostRequest
import com.potato.velog.service.post.dto.response.PostInfoResponse
import org.springframework.web.bind.annotation.*

@RestController
class PostController(
        private val postService: PostService
) {

    @Auth
    @PostMapping("/api/v1/post")
    fun addPost(
            @RequestBody request: AddPostRequest,
            @MemberId memberId: Long
    ): ApiResponse<PostInfoResponse> {
        return ApiResponse.success(postService.addPost(request, memberId))
    }

    @GetMapping("/api/v1/posts")
    fun retrievePostsPagination(
            request: RetrievePostsPagination
    ): ApiResponse<List<PostPaginationResponse>> {
        return ApiResponse.success(postService.retrievePostsPagination(request))
    }

    @Auth
    @PutMapping("/api/v1/post/{postId}")
    fun updatePost(
            @PathVariable postId: Long,
            @RequestBody request: UpdatePostRequest,
            @MemberId memberId: Long
    ): ApiResponse<PostInfoResponse> {
        return ApiResponse.success(postService.updatePost(postId, request, memberId))
    }

    @Auth
    @DeleteMapping("/api/v1/post/{postId}")
    fun deletePost(
            @PathVariable postId: Long,
            @MemberId memberId: Long
    ): ApiResponse<String> {
        postService.deletePost(postId, memberId)
        return ApiResponse.OK
    }

}