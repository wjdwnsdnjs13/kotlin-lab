package com.lab.labkotlin.repository

import com.lab.labkotlin.repository.entity.PostEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostJpaRepository: JpaRepository<PostEntity, Long>
