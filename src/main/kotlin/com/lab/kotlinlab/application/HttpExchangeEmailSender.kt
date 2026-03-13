package com.lab.labkotlin.application

import com.lab.labkotlin.application.email.EmailRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import java.util.Base64

@Component
class HttpExchangeEmailSender(
    private val mailgunHttpClient: MailgunHttpClient,
    @Value("\${mailgun.api-key}") private val apiKey: String,
    @Value("\${mailgun.domain}") private val domain: String,
    @Value("\${mailgun.from-email}") private val fromEmail: String,
) : EmailSender {
    override suspend fun send(request: EmailRequest) {
        val auth = "Basic " + Base64.getEncoder().encodeToString("api:$apiKey".toByteArray())
        val formData =
            LinkedMultiValueMap<String, String>().apply {
                add("from", fromEmail)
                add("to", request.to)
                add("subject", request.title)
                add("text", request.body)
            }

        mailgunHttpClient.send(domain, auth, formData)
    }
}
