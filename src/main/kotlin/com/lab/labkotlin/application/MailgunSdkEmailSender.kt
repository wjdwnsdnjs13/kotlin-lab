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
    @Value("\${spring.mail.username}")
    private val domain: String,
) : EmailSender {
    private val mailgunMessagesApi: MailgunMessagesApi =
        MailgunClient.config(apiKey)
            .createApi(MailgunMessagesApi::class.java)

    private val logger = LoggerFactory.getLogger(MailgunSdkEmailSender::class.java)

    override suspend fun send(emailRequest: EmailRequest) {
        logger.info("Mailgun SDK Email 전송 시작: $emailRequest")
        val resonse: MessageResponse =
            mailgunMessagesApi.sendMessage(
                emailRequest.from,
                Message.builder()
                    .from(emailRequest.from)
                    .to(emailRequest.to)
                    .subject(emailRequest.subject)
                    .text(emailRequest.body)
                    .build(),
            )
        logger.info("Mailgun SDK Email 전송 결과: $resonse")
    }
}
