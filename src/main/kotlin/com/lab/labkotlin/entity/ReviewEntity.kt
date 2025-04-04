package com.lab.labkotlin.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class ReviewEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var reviewId: Long? = null,
    var memberId: Long,
    var title: String,
    var content: String,
    var viewCount: Long,
) {

}