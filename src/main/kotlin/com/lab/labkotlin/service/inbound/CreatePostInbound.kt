package com.lab.labkotlin.service.inbound

data class CreatePostInbound(
    val title: String,
    val content: String,
) {
    companion object{
        fun of(
            title: String,
            content: String
        ): CreatePostInbound = CreatePostInbound(
            title = title,
            content = content,
        )
    }
}
