package com.lab.kotlinlab.controller

import com.lab.kotlinlab.controller.req.SendKafkaMessageRequest
import com.lab.kotlinlab.service.KafkaProducer
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/api/kafka")
class KafkaController(
    private val kafkaProducer: KafkaProducer,
) {
    @PostMapping("/send")
    fun send(
        @RequestBody sendKafkaMessageRequest: SendKafkaMessageRequest,
    ) {
        kafkaProducer.sendMessage(
            sendKafkaMessageRequest.topic,
            sendKafkaMessageRequest.message,
        )
    }
}
