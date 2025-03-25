package com.lab.labkotlin.scheduler

import com.lab.labkotlin.common.Message
import com.lab.labkotlin.common.MessageConsumer
import com.lab.labkotlin.common.MessageFactory
import com.lab.labkotlin.common.MessageType
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class MessageScheduler(
    private val messageConsumer: MessageConsumer
) {
    private val log = LoggerFactory.getLogger(MessageScheduler::class.java)

    @Scheduled(cron = "*/3 * * * * *")
    fun supplyMessage() {
        log.info("-----------Supplying message...-------------")
        messageConsumer.consume()

    }
}