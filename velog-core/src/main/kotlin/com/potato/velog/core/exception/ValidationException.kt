package com.potato.velog.core.exception

class ValidationException(
    override val message: String = ""
) : PotatoVelogException(message)
