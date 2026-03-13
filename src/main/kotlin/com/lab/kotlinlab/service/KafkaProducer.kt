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
            kafkaTemplate.send(topic, message)
                .whenComplete { result, exception ->
                    if (exception == null) {
                        log.info(
                            "메시지 발송 성공 : $message, " +
                                "\n partition: ${result?.recordMetadata?.partition()}, " +
                                "\n offset: ${result?.recordMetadata?.offset()}",
                        )
                    } else {
                        log.error("메시지 발송 실패 : $message", exception)
                    }
                }
            log.info("발송한 성공")
        } catch (e: Exception) {
            log.error("메시지 발송 중 예외 발생 : $message", e)
        }
    }
}
