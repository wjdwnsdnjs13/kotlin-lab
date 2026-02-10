package com.lab.labkotlin.service.outbound

data class EmailComparisonResult(
    val results: List<EmailSendResult>,
    val fastestMethod: String?,
)
