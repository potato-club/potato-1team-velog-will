package com.potato.velog.core.domain.post

import com.potato.velog.core.domain.BaseTimeEntity
import javax.persistence.*

@Entity
class Post(
    memberId: Long,
    title: String,
    content: String,
    status: PostStatus
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
        protected set

    @Column(nullable = false)
    var memberId: Long = memberId
        protected set

    @Column(nullable = false)
    var title: String = title
        protected set

    @Column(nullable = false, columnDefinition = "TEXT")
    var content: String = content
        protected set

    var status: PostStatus = status
        protected set

}