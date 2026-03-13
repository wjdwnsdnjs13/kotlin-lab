package com.lab.kotlinlab.controller

import com.lab.kotlinlab.controller.req.ODsayCallCountReq
import com.lab.kotlinlab.domain.MixpanelEvent
import com.lab.kotlinlab.domain.ODsayCallCountProperty
import org.springframework.context.ApplicationEventPublisher
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/mixpanel")
@RestController
class MixpanelEventController(
    val applicationEventPublisher: ApplicationEventPublisher,
) {
    @PostMapping("/odsay-call-count")
    fun oDsayCallCountEvent(
        @RequestBody
        oDsayCallCountReq: ODsayCallCountReq,
    ) {
        println("Received ODsay Call Count Event: $oDsayCallCountReq")
        applicationEventPublisher.publishEvent(
            MixpanelEvent(
                mixpanelEventName = MixpanelEvent.MixpanelEventName.ODSAY_CALL_COUNT,
                memberId = oDsayCallCountReq.memberId,
                property =
                    ODsayCallCountProperty(
                        startX = "12.12",
                        startY = "123.123",
                        endX = "21.21",
                        endY = "321.321",
                        oDsayCallCount = oDsayCallCountReq.oDsayCallCount,
                        routeCount = oDsayCallCountReq.routeCount,
                    ),
            ),
        )
    }
}
