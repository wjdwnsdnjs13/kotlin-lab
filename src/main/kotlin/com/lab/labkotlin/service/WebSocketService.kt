package com.lab.labkotlin.service

import com.github.benmanes.caffeine.cache.Cache
import com.github.benmanes.caffeine.cache.Caffeine
import org.springframework.stereotype.Service
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import java.util.concurrent.TimeUnit

@Service
class WebSocketService {

//    TODO : 캐시 미스일 경우 DB에서 데이터 가져오는 로직 추가 필요
    val caffeineCache: Cache<String, WebSocketSession> = Caffeine.newBuilder()
        .maximumSize(1000)
        .expireAfterAccess(10, TimeUnit.MINUTES)
        .recordStats()
        .build()

    fun createSession(session: WebSocketSession) {
        println("웹소켓 연결 생성: ${session.id}")
        caffeineCache.put(session.id, session)
    }

    fun sendMessageToAll(session: WebSocketSession, message: TextMessage) {
        println("수신된 메시지: ${message.payload} from ${session.id}")
        caffeineCache.asMap().forEach {
            val clientSession = it.value

            if(clientSession.isOpen && !clientSession.id.equals(session.id))
                clientSession.sendMessage(TextMessage(message.payload))
        }
    }

    fun closeSession(session: WebSocketSession, status: CloseStatus) {
        if(session.isOpen){
            session.close(status)
        }
        caffeineCache.invalidate(session.id)
    }
}
