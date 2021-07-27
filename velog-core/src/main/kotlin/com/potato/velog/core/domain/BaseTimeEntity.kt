package com.potato.velog.core.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTimeEntity(
    createdAt: LocalDateTime? = null,
    updatedAt: LocalDateTime? = null
) {

    @CreatedDate
    var createdAt: LocalDateTime? = createdAt
        protected set

    @LastModifiedDate
    var updatedAt: LocalDateTime? = updatedAt
        protected set

}
