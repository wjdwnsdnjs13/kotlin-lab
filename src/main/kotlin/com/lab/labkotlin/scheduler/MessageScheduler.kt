package com.lab.labkotlin.scheduler

import com.lab.labkotlin.common.MessageConsumer
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class MessageScheduler(
    private val messageConsumer: MessageConsumer,
) {
    private val log = LoggerFactory.getLogger(MessageScheduler::class.java)

//    @Scheduled(cron = "* */5 * * * *")
//    fun supplyMessage() {
//        log.info("-----------Supplying message...-------------")
//        messageConsumer.consume()
//
//    }
}
