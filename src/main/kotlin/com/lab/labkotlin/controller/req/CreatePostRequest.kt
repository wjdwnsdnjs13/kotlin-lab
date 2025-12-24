package com.lab.labkotlin.controller.req

import com.lab.labkotlin.domain.Post

data class CreatePostRequest(
    val title: String,
    val content: String,
) {
    fun toDomain() = Post.createPost(
        title = title,
        content = content,
    )
}
