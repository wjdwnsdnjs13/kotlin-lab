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
    @Value("\${spring.mail.username}") private val domain: String,
) : EmailSender {
    override suspend fun send(request: EmailRequest) {
        val auth = "Basic " + Base64.getEncoder().encodeToString("api:$apiKey".toByteArray())
        val formData =
            LinkedMultiValueMap<String, String>().apply {
                add("from", "sender@$domain")
                add("to", request.to)
                add("subject", request.subject)
                add("text", request.body)
            }

        mailgunHttpClient.send(domain, auth, formData)
    }
}
