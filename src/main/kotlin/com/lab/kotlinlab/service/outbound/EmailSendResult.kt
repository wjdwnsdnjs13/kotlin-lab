package com.lab.kotlinlab.service.outbound

import com.lab.kotlinlab.application.email.EmailSendMethod

data class EmailSendResult(
    val method: EmailSendMethod,
    val durationMs: Long,
    val success: Boolean,
    val errorMessage: String? = null,
)
