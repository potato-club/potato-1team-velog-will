package com.potato.velog.core.exception

class UnAuthorizedException(
    override val message: String = ""
) : PotatoVelogException(message)