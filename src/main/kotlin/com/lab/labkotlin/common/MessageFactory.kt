package com.lab.labkotlin.common

import org.springframework.stereotype.Component

@Component
class MessageFactory(
    val messageFailHandler: MessageFailHandler
) {

    fun createMessage(messageType: MessageType, message: String): Message {
        return Message(messageType, message, messageFailHandler)
    }

}