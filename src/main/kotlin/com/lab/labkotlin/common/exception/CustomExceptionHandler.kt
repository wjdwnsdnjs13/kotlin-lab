package com.lab.labkotlin.common.exception

import com.fasterxml.jackson.databind.exc.MismatchedInputException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.stereotype.Component
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.stream.Collectors

@RestControllerAdvice
class CustomExceptionHandler {
    private val logger: Logger = LoggerFactory.getLogger(CustomExceptionHandler::class.java)

    @ExceptionHandler(BusinessException::class)
    fun businessExceptionHandler(e: BusinessException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            e.httpStatus,
            e.code,
            e.message?:""
        )
        return ResponseEntity.status(e.httpStatus).body(errorResponse)
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    protected fun handleMethodArgumentNotValidException(
        exception: MethodArgumentNotValidException,
    ) : Map<String, String>{
        val errors: MutableMap<String, String> = HashMap()
        exception.bindingResult.fieldErrors.forEach { error ->
            errors[error.field] = error.defaultMessage ?: "Error 설정된 메시지가 없습니다."
        }

        return errors
    }


    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleHttpMessageNotReadableException(exception: HttpMessageNotReadableException): ErrorCode {
        logger.error("HttpMessageNotReadableException: {}", exception)

        val exceptionCode: ErrorCode =
            when (val cause = exception.cause) {
                is MismatchedInputException -> {
                    val fieldName: String =
                        cause.path
                            .stream()
                            .map { it.fieldName }
                            .collect(Collectors.joining("."))

                    NotNullException(fieldName = fieldName)
                }

                else -> JsonParseException()
            }

        return exceptionCode
    }
}
