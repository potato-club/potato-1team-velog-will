package com.potato.velog.core.exception

class NotFoundException(
    override val message: String = ""
) : PotatoVelogException(message)