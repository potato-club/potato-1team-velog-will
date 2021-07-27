package com.potato.velog.core.exception

class ConflictException(
    override val message: String = ""
) : PotatoVelogException(message)