package com.potato.velog.core.domain.post

import com.potato.velog.core.domain.post.repository.PostRepositoryCustom
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long>, PostRepositoryCustom