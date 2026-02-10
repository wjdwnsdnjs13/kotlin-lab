package com.lab.labkotlin.service.outbound

import com.lab.labkotlin.application.email.EmailSendMethod

data class EmailSendResult(
    val method: EmailSendMethod,
    val durationMs: Long,
    val success: Boolean,
    val errorMessage: String? = null,
)
