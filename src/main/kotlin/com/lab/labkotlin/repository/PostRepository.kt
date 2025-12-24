package com.lab.labkotlin.repository

import com.lab.labkotlin.domain.Post
import com.lab.labkotlin.repository.entity.PostEntity
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrNull

@Repository
class PostRepository(
    val postJpaRepository: PostJpaRepository
) {
    fun save(post: Post) : Post = postJpaRepository.save(PostEntity.from(post)).toDomain()

    fun findAll(): List<Post> = postJpaRepository.findAll().map { it.toDomain() }

    fun findById(id: Long): Post? = postJpaRepository.findById(id).map { it.toDomain() }.getOrNull()

    fun delete(post: Post): Post = postJpaRepository.save(PostEntity.from(post)).toDomain()

    fun update(post: Post): Post = postJpaRepository.save(PostEntity.from(post)).toDomain()
}
