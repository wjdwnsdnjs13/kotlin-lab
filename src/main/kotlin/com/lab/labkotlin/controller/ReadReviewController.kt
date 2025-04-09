package com.lab.labkotlin.controller

import com.lab.labkotlin.domain.Review
import com.lab.labkotlin.service.ReadReviewService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/review")
class ReadReviewController(
    private val readReviewService: ReadReviewService,
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findByMemberId(memberId: Long): List<Review> {
        return readReviewService.findByMemberId(memberId)
    }

    @GetMapping("/{reviewId}")
    @ResponseStatus(HttpStatus.OK)
    fun findByReviewId(reviewId: Long): Review {
        return readReviewService.findByReviewId(reviewId)
    }

    
}