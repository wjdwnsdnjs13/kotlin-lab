package com.lab.labkotlin.domain

class MixpanelEvent(
    val mixpanelEventName: MixpanelEventName,
    val memberId: Long,
    val property: MixpanelEventProperty,
) {
    enum class MixpanelEventName(val value: String) {
        ODSAY_CALL_COUNT("odsay_call_count"),
    }
}
