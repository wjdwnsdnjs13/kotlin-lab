package com.lab.kotlinlab.controller.req

data class SendKafkaMessageRequest(
    val topic: String,
    val message: String,
)
