package com.potato.velog.core.config

import com.potato.velog.core.PotatoVelogCoreRoot
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@ComponentScan(basePackageClasses = [PotatoVelogCoreRoot::class])
@Configuration
class PotatoVelogCoreConfig
