package com.lab.kotlinlab.application.email

data class EmailRequest(
    val to: String,
    val title: String,
    val body: String,
    val method: EmailSendMethod,
) {
    companion object {
        fun of(
            to: String,
            title: String,
            body: String,
            method: EmailSendMethod,
        ): EmailRequest {
            return EmailRequest(
                to = to,
                title = title,
                body = body,
                method = method,
            )
        }
    }
}
