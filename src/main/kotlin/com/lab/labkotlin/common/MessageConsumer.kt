package com.lab.labkotlin.common

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.stream.IntStream

@Component
class MessageConsumer(
    private val messageHandlerList: List<MessageHandler>,
    private val messageFailHandler: MessageFailHandler,
    private val messageQueue: MessageQueue,
    private val messageFactory: MessageFactory
) {
    private val threadPoolSize = 2
    private var isTerminated = true
    private val log = LoggerFactory.getLogger(MessageConsumer::class.java)

    fun consume(){
        log.warn("메시지 큐 내부 메시지 확인")
        for(i in 1..10) {
            messageQueue.add(messageFactory.createMessage(MessageType.NOTI, "테스트 메시지 $i"))
        }
        if(!messageQueue.isEmpty() && isTerminated){
            executeThreadPool()
        }
    }

    private fun executeThreadPool(){
        isTerminated = false

        log.warn("현재 메시지 개수 : ${messageQueue.size()}")
        log.warn("현재 설정된 스레드 풀 크기 : $threadPoolSize")
        log.info("현재 메시지 : ${messageQueue.queue.map { it.content }}")
        val executor = Executors.newFixedThreadPool(threadPoolSize)

        IntStream.range(0, threadPoolSize).forEach{ threadNumber ->
            CompletableFuture.runAsync(this::process, executor)
        }
        executor.shutdown()
    }

    private fun process(){
        log.info("메시지 처리 시작")
        var message : Message
        while (!messageQueue.isEmpty()){
            message = messageQueue.poll()?: break
            log.info("메시지 처리 중")
            handleMessage(message)
        }
        isTerminated = true
    }

    private fun handleMessage(
        message : Message
    ){

        messageHandlerList.forEach { messageHandler ->
            try {
                messageHandler.handle(message)
            } catch (e: Exception) {
                log.error("메시지 처리 실패")
                messageFailHandler.handleFail(message, e)
            }
        }
    }
}