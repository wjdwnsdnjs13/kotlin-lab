package com.lab.labkotlin.common

class Message(
    val messageType: MessageType,
    val content: String,
    val messageFailHandler: MessageFailHandler
) {
    private var failCount = 0L
    private var exceptionList = mutableListOf<Exception>()

    fun addException(e: Exception) {
        exceptionList.add(e)
    }

    fun increaseFailCount() {
        failCount++
    }

    fun takeFail(e: Exception) {
        messageFailHandler.handleFail(this, e)
    }

    fun getFailCount(): Long {
        return failCount
    }

    fun getExceptionList(): List<Exception> {
        return exceptionList
    }
}