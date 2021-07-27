package com.potato.velog.api.config

import com.potato.velog.api.PotatoVelogApplication
import com.potato.velog.core.PotatoVelogCoreRoot
import com.potato.velog.core.config.PotatoVelogCoreConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@ComponentScan(
    basePackageClasses = [
        PotatoVelogCoreRoot::class,
        PotatoVelogApplication::class
    ]
)
@Configuration
class PotatoVelogApiConfig