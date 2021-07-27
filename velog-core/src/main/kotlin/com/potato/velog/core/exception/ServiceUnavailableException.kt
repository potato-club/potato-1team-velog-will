package com.potato.velog.core.exception

class ServiceUnavailableException(
    override val message: String = ""
) : PotatoVelogException(message)