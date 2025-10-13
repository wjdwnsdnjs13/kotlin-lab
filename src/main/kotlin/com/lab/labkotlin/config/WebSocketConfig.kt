package com.lab.labkotlin.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@Configuration
@EnableWebSocket
class WebSocketConfig(
    private val webSocketHandler: WebSocketHandler,
) : WebSocketConfigurer {
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
//        TODO : 모든 도메인 허용, 필요에 따라 특정 도메인만 허용하도록 변경 가능
        registry.addHandler(webSocketHandler, "/ws/chat")
            .setAllowedOrigins("*")
    }
}
