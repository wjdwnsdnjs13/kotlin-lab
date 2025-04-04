package com.lab.labkotlin.domain

import com.lab.labkotlin.entity.ReviewEntity

class Review(
    var reviewId: Long? = null,
    var memberId: Long = 0,
    var title: String = "",
    var content: String = "",
    var viewCount: Long = 0,
) {
    fun toReviewEntity(): ReviewEntity {
        return ReviewEntity(
            memberId = memberId,
            title = title,
            content = content,
            viewCount = viewCount
        )
    }
}