package com.lab.labkotlin.controller.req

data class ODsayCallCountReq(
    val memberId: Long,
    val oDsayCallCount: Int,
    val routeCount: Int,
)
