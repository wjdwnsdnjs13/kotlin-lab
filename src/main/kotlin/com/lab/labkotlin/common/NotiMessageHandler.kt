package com.lab.labkotlin.common

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class NotiMessageHandler: MessageHandler {
    private val log = LoggerFactory.getLogger(NotiMessageHandler::class.java)

    override fun handle(message: Message) {
        if(message.messageType != MessageType.NOTI) {
            log.warn("메시지 핸들러가 처리할 수 없는 메시지 타입입니다.")
            return
        }
        log.info("${Thread.currentThread().name}가 ${message.messageType} 타입의 메시지 {${message.content}}를 처리했습니다.")
    }
}