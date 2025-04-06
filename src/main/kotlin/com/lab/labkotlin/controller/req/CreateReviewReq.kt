package com.lab.labkotlin.controller.req

class CreateReviewReq(
    var memberId: Long = 0L,
    var title: String = "",
    var content: String = "",
) {
}