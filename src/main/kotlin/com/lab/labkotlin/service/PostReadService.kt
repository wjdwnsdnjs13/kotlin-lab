package com.lab.labkotlin.service

import com.lab.labkotlin.domain.Post
import com.lab.labkotlin.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostReadService(
    val postRepository: PostRepository,
) {
    fun findAll(): List<Post> = postRepository.findAll()

    fun findById(id: Long): Post = postRepository.findById(id)?: throw RuntimeException("Post with id $id not found")
}
