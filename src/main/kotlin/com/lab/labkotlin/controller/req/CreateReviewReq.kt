package com.lab.labkotlin.controller.req

class CreateReviewReq(
    var memberId: Long,
    var title: String,
    var content: String,
    var viewCount: Long,
) {
}