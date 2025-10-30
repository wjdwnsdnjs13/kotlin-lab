package com.lab.labkotlin.controller

import com.lab.labkotlin.service.WebSocketService
import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

@Component
class ChatWebSocketHandler(
    private val webSocketService: WebSocketService,
) : TextWebSocketHandler() {

    override fun afterConnectionEstablished(session: WebSocketSession) {
        webSocketService.createSession(session)
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        webSocketService.sendMessageToAll(session, message)
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        println("웹소켓 연결 종료: ${session.id}, 상태: $status")
        webSocketService.closeSession(session, status)
    }

}
