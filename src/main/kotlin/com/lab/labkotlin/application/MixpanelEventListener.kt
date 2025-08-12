package com.lab.labkotlin.application

import com.lab.labkotlin.domain.MixpanelEvent
import com.mixpanel.mixpanelapi.ClientDelivery
import com.mixpanel.mixpanelapi.MessageBuilder
import com.mixpanel.mixpanelapi.MixpanelAPI
import org.json.JSONObject
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class MixpanelEventListener(
    @Value("\${mixpanel.token}")
    val token: String,
) {
    private val delivery: ClientDelivery = ClientDelivery()

    private val mixpanelAPI: MixpanelAPI = MixpanelAPI()

    @Async
    @EventListener
    fun eventTrack(mixpanelEvent: MixpanelEvent) {

        // 믹스패널 이벤트 메시지 생성
        val messageBuilder = MessageBuilder(token)

        // 이벤트 생성
        val sentEvent: JSONObject =
            messageBuilder.event(
                mixpanelEvent.memberId.toString(),
                mixpanelEvent.mixpanelEventName.value,
                JSONObject(mixpanelEvent.property),
            )
        println("Mixpanel Event: $sentEvent")
        delivery.addMessage(sentEvent)
        println("Mixpanel Delivery: $delivery")

        mixpanelAPI.deliver(delivery)
    }
}
