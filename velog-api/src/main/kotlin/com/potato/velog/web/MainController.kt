package com.potato.velog.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {

    @GetMapping("/")
    fun ping(): ApiResponse<String> {
        return ApiResponse.OK
    }

}