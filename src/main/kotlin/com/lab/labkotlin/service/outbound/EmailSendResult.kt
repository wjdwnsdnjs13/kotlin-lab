package com.lab.labkotlin.service.outbound

data class EmailSendResult(
    val method: String,
    val durationMs: Long,
    val success: Boolean,
    val errorMessage: String? = null,
)
