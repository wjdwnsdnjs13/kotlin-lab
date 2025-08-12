package com.lab.labkotlin.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/test")
class TestController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    fun getTest(): String {
        return "Get Test Success"
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    fun postTest(): String {
        return "Post Test Success"
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{resourceId}")
    fun getExceptionHanlderTest(): String {
        return throw TestException.ResourceNotFound()
    }
}
