package com.lab.labkotlin.common

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class MessageFailHandler(
    val messageQueue: MessageQueue
) {
    private val MAX_FAIL_COUNT = 100
    private val log = LoggerFactory.getLogger(MessageFailHandler::class.java)

    fun handleFail(message: Message, e: Exception) {
        message.addException(e)
        message.increaseFailCount()
        if(message.getFailCount() > MAX_FAIL_COUNT){
            handleTooManyFails(message)
        }else{
            messageQueue.add(message)
        }

    }

    fun handleTooManyFails(message: Message){
        log.warn("최대 실패 횟수 ${MAX_FAIL_COUNT}를 초과")
        log.warn("예외 리스트")
        val exceptionList = message.getExceptionList()
        log.warn("실패한 메시지 : ${message}")
        exceptionList.forEach { exception ->
            exception.printStackTrace()
            log.warn("-----------------------------")
        }
        log.warn("예외 리스트 종료")

    }

}