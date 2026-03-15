package com.lab.kotlinlab.application.email

import com.lab.kotlinlab.application.KafkaTopic
import com.lab.labkotlin.application.email.EmailRequest
import com.lab.labkotlin.application.email.EmailSendMethod

data class EmailEvent(
    val messageId: String,
    val topic: KafkaTopic = KafkaTopic.EMAIL_EVENT,
    val emailRequest: EmailRequest,
    val method: EmailSendMethod,
) {
    companion object {
        fun of(
            messageId: String,
            emailRequest: EmailRequest,
            method: EmailSendMethod,
        ): EmailEvent {
            return EmailEvent(
                messageId = messageId,
                emailRequest = emailRequest,
                method = method,
            )
        }
    }
}
