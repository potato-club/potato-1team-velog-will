package com.potato.velog.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

abstract class BaseTimeEntity(
    createdAt: LocalDateTime? = null,
    updatedAt: LocalDateTime? = null
) {

    @CreatedDate
    var createdAt: LocalDateTime? = createdAt
        private set

    @LastModifiedDate
    var updatedAt: LocalDateTime? = updatedAt
        private set

}