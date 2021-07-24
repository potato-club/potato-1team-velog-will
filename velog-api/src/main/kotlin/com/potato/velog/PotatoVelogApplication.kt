package com.potato.velog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PotatoVelogApplication

fun main(args: Array<String>) {
    runApplication<PotatoVelogApplication>(*args)
}