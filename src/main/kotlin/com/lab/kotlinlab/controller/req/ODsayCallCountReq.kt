package com.lab.kotlinlab.controller.req

data class ODsayCallCountReq(
    val memberId: Long,
    val oDsayCallCount: Int,
    val routeCount: Int,
)
