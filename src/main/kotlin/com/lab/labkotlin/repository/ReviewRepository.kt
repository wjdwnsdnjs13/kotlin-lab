package com.lab.labkotlin.repository

import com.lab.labkotlin.entity.ReviewEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository: JpaRepository<ReviewEntity, Long>{
}