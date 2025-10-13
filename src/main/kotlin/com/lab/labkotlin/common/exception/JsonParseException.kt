package com.lab.labkotlin.common.exception

import org.springframework.http.HttpStatus

class JsonParseException(
    val httpStatusCode: HttpStatus = HttpStatus.BAD_REQUEST,
    val errorCode: String = "JSON-400-01",
    val errorMessage: String = "JSON 파싱 오류가 발생했습니다.",
    ) : ErrorCode{
    override fun getStatus(): HttpStatus = httpStatusCode
    override fun getCode(): String = errorCode
    override fun getMessage(): String = errorMessage
}
