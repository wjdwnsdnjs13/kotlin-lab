package com.lab.kotlinlab.common.exception

import org.springframework.http.HttpStatus

open class BusinessException(
    errorCode: ErrorCode,
) : RuntimeException(errorCode.getMessage()) {
    val httpStatus: HttpStatus
    val code: String

    init {
        httpStatus = errorCode.getStatus()
        code = errorCode.getCode()
    }
}
