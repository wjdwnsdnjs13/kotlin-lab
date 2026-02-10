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
) : EmailSender {
    override suspend fun send(request: EmailRequest) {
        // 지하철 API 코드에서 사용한 ApiClientUtils.callApiWithRetry 로직을 여기에 적용 가능
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
