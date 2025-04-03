package com.lab.labkotlin.controller

import com.lab.labkotlin.controller.req.CreateReviewReq
import com.lab.labkotlin.controller.res.CreateReviewRes
import com.lab.labkotlin.domain.Review
import com.lab.labkotlin.service.ReviewService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/review")
class ReviewController(
    private val reviewService: ReviewService
) {
    @PostMapping("/{reviewId}")
    fun createReview(createReviewReq: CreateReviewReq): CreateReviewRes {
        val review = reviewService.createReview(Review().also {review ->
            review.memberId = createReviewReq.memberId
            review.title = createReviewReq.title
            review.content = createReviewReq.content
            review.viewCount = createReviewReq.viewCount
        })
        // TODO : 여기부터
        return CreateReviewRes().also { res ->
            res.reviewId = review.reviewId?: throw IllegalStateException("reviewId is null")
            review.memberId = review.memberId
            review.title = review.title
            review.content = review.content
            review.viewCount = review.viewCount
        }
    }
}