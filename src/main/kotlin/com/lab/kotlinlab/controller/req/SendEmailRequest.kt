package com.lab.labkotlin.controller.req

import com.lab.labkotlin.application.email.EmailRequest
import com.lab.labkotlin.application.email.EmailSendMethod

data class SendEmailRequest(
    val to: String,
    val title: String,
    val body: String,
) {
    fun toEmailRequest(method: EmailSendMethod): EmailRequest {
        return EmailRequest.of(
            to = this.to,
            title = this.title,
            body = this.body,
            method = method,
        )
    }
}
