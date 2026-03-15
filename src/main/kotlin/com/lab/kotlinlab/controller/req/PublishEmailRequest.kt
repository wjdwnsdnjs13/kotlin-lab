package com.lab.kotlinlab.controller.req

import com.lab.labkotlin.application.email.EmailRequest
import com.lab.labkotlin.application.email.EmailSendMethod

data class PublishEmailRequest(
    val method: EmailSendMethod,
    val to: String,
    val title: String,
    val body: String,
) {
    fun toEmailRequest(): EmailRequest {
        return EmailRequest.of(
            to = this.to,
            title = this.title,
            body = this.body,
            method = this.method,
        )
    }
}
