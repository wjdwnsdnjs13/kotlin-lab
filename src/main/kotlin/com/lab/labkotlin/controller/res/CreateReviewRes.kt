package com.lab.labkotlin.controller.res

import com.lab.labkotlin.domain.Review

class CreateReviewRes(
    var reviewId: Long,
    var memberId: Long,
    var title: String,
    var content: String,
    var viewCount: Long,
    ) {
    fun fromReview(review: Review) {
        this.reviewId = review.reviewId?: 0L
        this.memberId = review.memberId
        this.title = review.title
        this.content = review.content
        this.viewCount = review.viewCount
    }
}