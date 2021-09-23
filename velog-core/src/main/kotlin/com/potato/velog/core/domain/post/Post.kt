package com.potato.velog.core.domain.post

import com.potato.velog.core.domain.BaseTimeEntity
import javax.persistence.*

@Entity
class Post(
    @Column(nullable = false)
    var memberId: Long,

    @Column(nullable = false)
    var title: String,

    @Column(nullable = false, columnDefinition = "TEXT")
    var content: String,

    @Enumerated(EnumType.STRING)
    var status: PostStatus
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    fun update(title: String, content: String, status: PostStatus) {
        this.title = title;
        this.content = content
        this.status = status
    }

    fun delete() {
        this.status = PostStatus.DELETED
    }

}