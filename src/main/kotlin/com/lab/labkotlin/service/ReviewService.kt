package com.lab.labkotlin.service

import com.lab.labkotlin.domain.Review
import com.lab.labkotlin.repository.ReviewRepository
import org.springframework.stereotype.Service

@Service
class ReviewService(
    private val reviewRepository: ReviewRepository,
) {
    fun createReview(review: Review): Review {
        val reviewEntity = reviewRepository.save(review.toReviewEntity())
        return Review().also { review ->
            review.reviewId = reviewEntity.reviewId
            review.memberId = reviewEntity.memberId
            review.title = reviewEntity.title
            review.content = reviewEntity.content
            review.viewCount = reviewEntity.viewCount
        }
    }
}