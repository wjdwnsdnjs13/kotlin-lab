package com.lab.labkotlin.controller

import com.lab.labkotlin.controller.req.PostRedisTestReq
import com.lab.labkotlin.controller.res.PostRedisTestRes
import com.lab.labkotlin.service.RedisTestService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/test")
class TestController(
    private val redisTestService: RedisTestService
) {

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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/redis")
    fun getRedisTest(@RequestParam key: String): String {
        return redisTestService.get(key)
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/redis")
    fun postRedisTest(@RequestBody postRedisTestReq: PostRedisTestReq) {
        redisTestService.set(postRedisTestReq.key, postRedisTestReq.value)
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/redis")
    fun deleteRedisTest(postRedisTestReq: PostRedisTestReq) {
        redisTestService.delete(postRedisTestReq.key)
    }

}