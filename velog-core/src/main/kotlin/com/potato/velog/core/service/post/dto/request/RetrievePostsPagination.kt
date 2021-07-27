package com.potato.velog.core.service.post.dto.request

data class RetrievePostsPagination(
    val lastPostId: Long?,
    val title: String?,
    val size: Long
)
