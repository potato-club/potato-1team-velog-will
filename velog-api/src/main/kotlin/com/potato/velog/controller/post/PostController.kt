package com.potato.velog.controller.post

import com.potato.velog.controller.dto.ApiResponse
import com.potato.velog.service.post.PostService
import com.potato.velog.service.post.dto.request.AddPostRequest
import com.potato.velog.core.domain.post.repository.PostPaginationDto
import com.potato.velog.service.post.dto.request.RetrievePostsPagination
import com.potato.velog.service.post.dto.response.PostInfoResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

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

}