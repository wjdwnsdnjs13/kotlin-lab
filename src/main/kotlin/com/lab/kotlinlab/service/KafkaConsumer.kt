package com.lab.kotlinlab.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer {
    @KafkaListener(topics = ["my-topic"], groupId = "kotlin-lab")
    fun consumeMessage(
        topic: String,
        message: String,
    ) {
        println("토픽으로부터 받은 메시지 '$topic': $message")
    }
}
