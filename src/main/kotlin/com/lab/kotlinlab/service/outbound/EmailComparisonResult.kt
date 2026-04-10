package com.lab.kotlinlab.service.outbound

import com.lab.kotlinlab.application.email.EmailSendMethod

data class EmailComparisonResult(
    val results: List<EmailSendResult>,
    val fastestMethod: EmailSendMethod,
)
