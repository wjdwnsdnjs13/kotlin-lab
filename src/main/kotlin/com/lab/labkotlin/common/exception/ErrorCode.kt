package com.lab.labkotlin.common.exception

import org.springframework.http.HttpStatus

interface ErrorCode {
    fun getStatus(): HttpStatus
    fun getCode(): String
    fun getMessage(): String
}