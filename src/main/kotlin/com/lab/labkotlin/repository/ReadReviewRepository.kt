package com.lab.labkotlin.repository

import com.lab.labkotlin.entity.ReviewEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReadReviewRepository: JpaRepository<ReviewEntity, Long> {
    fun findByMemberId(memberId: Long): MutableList<ReviewEntity>
}