package com.potato.velog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
internal class PotatoVelogApplication

internal fun main(args: Array<String>) {
    runApplication<PotatoVelogApplication>(*args)
}