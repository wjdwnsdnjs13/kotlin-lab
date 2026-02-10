package com.lab.labkotlin.application

import com.lab.labkotlin.application.email.EmailRequest
import com.mailgun.api.v3.MailgunMessagesApi
import com.mailgun.client.MailgunClient
import com.mailgun.model.message.Message
import com.mailgun.model.message.MessageResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class MailgunSdkEmailSender(
    @Value("\${mailgun.api-key}")
    private val apiKey: String,
    @Value("\${mailgun.domain}")
    private val domain: String,
    @Value("\${mailgun.from-email}")
    private val fromEmail: String,
) : EmailSender {
    private val mailgunMessagesApi: MailgunMessagesApi =
        MailgunClient.config(apiKey)
            .createApi(MailgunMessagesApi::class.java)

    private val logger = LoggerFactory.getLogger(MailgunSdkEmailSender::class.java)

    override suspend fun send(emailRequest: EmailRequest) {
        logger.info("Mailgun SDK Email 전송 시작: $emailRequest")
        val response: MessageResponse =
            mailgunMessagesApi.sendMessage(
                domain,
                Message.builder()
                    .from(fromEmail)
                    .to(emailRequest.to)
                    .subject(emailRequest.title)
                    .text(emailRequest.body)
                    .build(),
            )
        logger.info("Mailgun SDK Email 전송 결과: $response")
    }
}
