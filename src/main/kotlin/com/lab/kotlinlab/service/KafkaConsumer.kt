package com.lab.kotlinlab.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer {
    private val log: Logger = LoggerFactory.getLogger(KafkaConsumer::class.java)

    @KafkaListener(topics = ["\${spring.kafka.topics.my-topic}"], groupId = "kotlin-lab")
    fun consumeMessage(
        topic: String,
        message: String,
    ) {
        try {
            log.info("'$topic' 토픽으로부터 받은 메시지 : $message")
        } catch (e: Exception) {
            log.error("발생한 에러 메시지 : $message", e)
        }
    }
}
