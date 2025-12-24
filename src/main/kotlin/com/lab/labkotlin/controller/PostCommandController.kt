package com.lab.labkotlin.controller

import com.lab.labkotlin.controller.req.CreatePostRequest
import com.lab.labkotlin.controller.res.CreatePostResponse
import com.lab.labkotlin.service.PostCommandService
import com.lab.labkotlin.service.PostReadService
import com.lab.labkotlin.service.inbound.CreatePostInbound
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/posts")
@RestController
class PostCommandController(
    private val postReadService: PostReadService,
    private val postCommandService: PostCommandService,
    private val commandService: PostCommandService,
) {
    @PostMapping
    fun createPost(
        @RequestBody
        request: CreatePostRequest
    ): CreatePostResponse {
        val createdPost = postCommandService.createPost(CreatePostInbound.of(request.title, request.content))
        return CreatePostResponse(createdPost.id)
    }
}
