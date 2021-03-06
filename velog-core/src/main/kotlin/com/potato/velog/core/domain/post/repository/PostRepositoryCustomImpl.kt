package com.potato.velog.core.domain.post.repository

import com.potato.velog.core.domain.post.PostStatus
import com.potato.velog.core.domain.post.QPost.post
import com.potato.velog.core.domain.member.QMember.member
import com.potato.velog.core.domain.post.Post
import com.querydsl.jpa.impl.JPAQueryFactory

class PostRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
) : PostRepositoryCustom {

    override fun findWithPagination(lastPostId: Long?, title: String?, size: Long): List<PostProjection> {
        return queryFactory.select(
            QPostProjection(
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

    override fun findPostByIdAndMemberId(postId: Long, memberId: Long): Post? {
        return queryFactory.selectFrom(post)
            .where(
                post.id.eq(postId),
                post.memberId.eq(memberId)
            ).fetchOne()
    }

}