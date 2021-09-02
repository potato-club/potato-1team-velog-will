package com.potato.velog.common.dto

import com.potato.velog.core.domain.BaseTimeEntity
import java.time.LocalDateTime

open class BaseTimeResponse(
        var createdAt: LocalDateTime? = null,
        var updatedAt: LocalDateTime? = null
) {

    fun setBaseTime(baseTimeEntity: BaseTimeEntity) {
        this.createdAt = baseTimeEntity.createdAt
        this.updatedAt = baseTimeEntity.updatedAt
    }

}