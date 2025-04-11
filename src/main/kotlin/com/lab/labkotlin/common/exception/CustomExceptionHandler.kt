package com.lab.labkotlin.common.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CustomExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun businessExceptionHandler(e: BusinessException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            e.httpStatus,
            e.code,
            e.message?:""
        )
        return ResponseEntity.status(e.httpStatus).body(errorResponse)
    }

}