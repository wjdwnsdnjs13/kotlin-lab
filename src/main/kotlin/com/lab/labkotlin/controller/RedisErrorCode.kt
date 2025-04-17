package com.lab.labkotlin.controller

import com.lab.labkotlin.common.exception.ErrorCode
import org.springframework.http.HttpStatus

enum class RedisErrorCode(
    private val status: HttpStatus,
    private val code: String,
    private val message: String,
): ErrorCode {
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "REDIS-001", "요청한 리소스가 존재하지 않습니다.");

    override fun getStatus(): HttpStatus = status
    override fun getCode(): String = code
    override fun getMessage(): String = message
}