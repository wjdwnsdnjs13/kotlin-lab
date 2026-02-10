package com.lab.labkotlin.service.outbound

import com.lab.labkotlin.application.email.EmailSendMethod

data class EmailComparisonResult(
    val results: List<EmailSendResult>,
    val fastestMethod: EmailSendMethod,
)
