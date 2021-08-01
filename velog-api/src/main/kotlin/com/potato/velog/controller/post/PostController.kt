package com.potato.velog.controller.post

import com.potato.velog.controller.dto.ApiResponse
import com.potato.velog.service.post.PostService
import com.potato.velog.service.post.dto.request.AddPostRequest
import com.potato.velog.core.domain.post.repository.PostPaginationDto
import com.potato.velog.service.post.dto.request.RetrievePostsPagination
import com.potato.velog.service.post.dto.request.UpdatePostRequest
import com.potato.velog.service.post.dto.response.PostInfoResponse
import org.springframework.web.bind.annotation.*

@RestController
class PostController(
    private val postService: PostService
) {

    @PostMapping("/api/v1/post")
    fun addPost(
        @RequestBody request: AddPostRequest
    ): ApiResponse<PostInfoResponse> {
        return ApiResponse.success(postService.addPost(request, 100L))
    }

    @GetMapping("/api/v1/posts")
    fun retrievePostsPagination(
        request: RetrievePostsPagination
    ): ApiResponse<List<PostPaginationDto>> {
        return ApiResponse.success(postService.retrievePostsPagination(request))
    }

    @PutMapping("/api/v1/post/{postId}")
    fun updatePost(
        @PathVariable postId: Long,
        @RequestBody request: UpdatePostRequest,
    ): ApiResponse<PostInfoResponse> {
        return ApiResponse.success(postService.updatePost(postId, request, 100L))
    }

    @DeleteMapping("/api/v1/post/{postId}")
    fun deletePost(
        @PathVariable postId: Long
    ): ApiResponse<String> {
        postService.deletePost(postId, 100L)
        return ApiResponse.OK
    }

}