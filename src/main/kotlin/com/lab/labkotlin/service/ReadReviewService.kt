package com.lab.labkotlin.service

import com.lab.labkotlin.domain.Review
import com.lab.labkotlin.repository.ReadReviewRepository
import org.springframework.stereotype.Service

@Service
class ReadReviewService(
    private val readReviewRepository: ReadReviewRepository,
) {
    fun findByMemberId(memberId: Long): List<Review> {
        return readReviewRepository.findByMemberId(memberId).map { reviewEntity ->
            Review().also { review ->
                review.reviewId = reviewEntity.reviewId
                review.memberId = reviewEntity.memberId
                review.title = reviewEntity.title
                review.content = reviewEntity.content
                review.viewCount = reviewEntity.viewCount
            }
        }
    }

}