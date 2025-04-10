package com.lab.labkotlin.common.exception

import org.springframework.http.HttpStatus

data class ErrorResponse(
    val status: HttpStatus,
    val code: String,
    val message: String,
)