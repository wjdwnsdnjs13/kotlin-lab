package com.lab.labkotlin.controller.res

data class CreatePostResponse(
    val postId: Long,
) {
    companion object {
        fun from(postId: Long) = CreatePostResponse(postId)
    }
}
