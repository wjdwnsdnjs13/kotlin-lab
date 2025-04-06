package com.lab.labkotlin.controller.res

import com.lab.labkotlin.domain.Review

class CreateReviewRes(
    var reviewId: Long = 0L,
    var memberId: Long = 0L,
    var title: String = "",
    var content: String = "",
    var viewCount: Long = 0L,
    ) {
    fun fromReview(review: Review) {
        this.reviewId = review.reviewId?: throw IllegalStateException("reviewId is null")
        this.memberId = review.memberId
        this.title = review.title
        this.content = review.content
        this.viewCount = review.viewCount
    }
}