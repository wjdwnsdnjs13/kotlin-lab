package com.lab.kotlinlab.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>,
) {
    private val log: Logger = LoggerFactory.getLogger(KafkaProducer::class.java)

    fun sendMessage(
        topic: String,
        message: String,
    ) {
        try {
            log.info("발송한 메시지 : $message")
            kafkaTemplate.send(topic, message)
            log.info("발송한 성공")
        } catch (e: Exception) {
            log.error("발생한 에러 메시지 : $message", e)
        }
    }
}
