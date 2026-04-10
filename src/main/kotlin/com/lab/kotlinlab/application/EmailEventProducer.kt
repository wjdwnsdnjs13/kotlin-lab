package com.lab.kotlinlab.application

import com.fasterxml.jackson.databind.ObjectMapper
import com.lab.kotlinlab.application.email.EmailEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class EmailEventProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val objectMapper: ObjectMapper,
) {
    private val log: Logger = LoggerFactory.getLogger(EmailEventProducer::class.java)

    fun publish(emailEvent: EmailEvent): CompletableFuture<SendResult<String, String>> {
        val message: String = objectMapper.writeValueAsString(emailEvent)
        val partitionKey: String = emailEvent.emailRequest.to.value

        return kafkaTemplate.send(
            emailEvent.topic.value,
            partitionKey,
            message,
        ).whenComplete { result, exception ->
            if (exception == null) {
                log.info("${emailEvent.messageId} 이메일 요청 발행 성공: ${emailEvent.emailRequest.title}")
            } else {
                log.error("${emailEvent.messageId} 이메일 요청 발행 실패", exception)
            }
        }
    }
}
