package com.lab.labkotlin.common

import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentLinkedQueue

@Component
class MessageQueue(
    val queue: ConcurrentLinkedQueue<Message> = ConcurrentLinkedQueue()
) {
    fun add(message: Message) {
        queue.add(message)
    }

    fun poll(): Message? {
        return queue.poll()
    }

    fun isEmpty(): Boolean {
        return queue.isEmpty()
    }

    fun size(): Int {
        return queue.size
    }
}