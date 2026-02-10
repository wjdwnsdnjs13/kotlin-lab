package com.lab.labkotlin.application

import com.lab.labkotlin.application.email.Email
import com.lab.labkotlin.application.email.EmailRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Component

@Component
class SmtpEmailSender(
    val mailSender: JavaMailSender,
    @Value("\${spring.mail.username}")
    val fromEmail: Email,
) : EmailSender {
    override suspend fun send(request: EmailRequest) =
        mailSender.send(
            SimpleMailMessage().apply {
                setTo(request.to)
                setFrom(fromEmail.value)
                setSubject(request.subject)
                setText(request.body)
            },
        )
}
