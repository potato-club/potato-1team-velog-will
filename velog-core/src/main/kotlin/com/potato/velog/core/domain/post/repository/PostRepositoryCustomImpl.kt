package com.potato.velog.core.domain.post.repository

import com.potato.velog.core.domain.post.PostStatus
import com.querydsl.jpa.JPQLQueryFactory
import com.potato.velog.core.domain.post.QPost.post
import com.potato.velog.core.domain.member.QMember.member
import com.potato.velog.core.domain.post.repository.QPostPaginationDto

class PostRepositoryCustomImpl(
    private val queryFactory: JPQLQueryFactory
) : PostRepositoryCustom {

    override fun findWithPagination(lastPostId: Long?, title: String?, size: Long): List<PostPaginationDto> {
        return queryFactory.select(
            QPostPaginationDto(
                post.id, post.title, post.content, post.createdAt, post.updatedAt,
                member.name, member.profileUrl
            )
        )
            .from(post)
            .innerJoin(member).on(post.memberId.eq(member.id))
            .where(
                lastPostId?.let { post.id.lt(lastPostId) },
                post.status.eq(PostStatus.POSTED),
                title?.let { post.title.like("$title%") }
            )
            .orderBy(post.id.desc())
            .limit(size)
            .fetch()
    }

}