package com.lab.kotlinlab.controller.req

import com.lab.kotlinlab.application.email.Email
import com.lab.kotlinlab.application.email.EmailRequest
import com.lab.kotlinlab.application.email.EmailSendMethod

data class SendEmailRequest(
    val to: Email,
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
