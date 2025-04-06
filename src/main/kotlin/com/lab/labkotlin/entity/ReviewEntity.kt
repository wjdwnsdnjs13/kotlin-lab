package com.lab.labkotlin.entity

import jakarta.persistence.*

@Entity
@Table(name = "review_lab")
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