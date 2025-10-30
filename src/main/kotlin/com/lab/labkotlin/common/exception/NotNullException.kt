package com.lab.labkotlin.common.exception

import org.springframework.http.HttpStatus

class NotNullException(
    val httpStatusCode: HttpStatus = HttpStatus.BAD_REQUEST,
    val errorCode: String = "NOT_NULL-400-01",
    val fieldName: String,
    ) : ErrorCode{
    override fun getStatus(): HttpStatus = httpStatusCode
    override fun getCode(): String = errorCode
    override fun getMessage(): String =
        "필드 ${fieldName}의 값이 누락되었거나 형식이 올바르지 않습니다."
}
