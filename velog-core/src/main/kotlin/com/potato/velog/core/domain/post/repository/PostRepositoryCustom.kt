package com.potato.velog.core.domain.post.repository

interface PostRepositoryCustom {

    fun findWithPagination(lastPostId: Long?, title: String?, size: Long): List<PostPaginationDto>

}