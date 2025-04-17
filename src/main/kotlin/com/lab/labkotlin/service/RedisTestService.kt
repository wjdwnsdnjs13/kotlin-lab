package com.lab.labkotlin.service

import com.lab.labkotlin.controller.RedisErrorCode
import com.lab.labkotlin.controller.RedisException
import com.lab.labkotlin.controller.res.PostRedisTestRes
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class RedisTestService(
    private val redisTemplate: StringRedisTemplate
) {
    fun set(key: String, value: String, timeoutSeconds: Long = 60) {
        return redisTemplate.opsForValue().set(key, value, timeoutSeconds, TimeUnit.SECONDS)
    }

    fun get(key: String): String {
        return redisTemplate.opsForValue().get(key)?: throw RedisException.ResourceNotFound()
    }

    fun delete(key: String): Boolean {
        return redisTemplate.delete(key)
    }
}