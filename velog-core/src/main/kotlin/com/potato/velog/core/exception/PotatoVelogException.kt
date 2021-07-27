package com.potato.velog.core.exception

abstract class PotatoVelogException(
    override val message: String = ""
) : RuntimeException()
