package com.lab.labkotlin.common

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ViewCntMessageHandler: MessageHandler {
    private val log = LoggerFactory.getLogger(ViewCntMessageHandler::class.java)

    override fun handle(message: Message) {
        if(message.messageType != MessageType.UPDATE_VIEW_CNT) {
            log.warn("메시지 핸들러가 처리할 수 없는 메시지 타입입니다.")
            return
        }
        val result = message
        log.info("${Thread.currentThread().name}가 ${message.messageType} 타입의 메시지 {${message.content}}를 처리했습니다.")
    }
}