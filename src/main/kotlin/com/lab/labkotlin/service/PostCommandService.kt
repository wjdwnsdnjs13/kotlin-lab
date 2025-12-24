package com.lab.labkotlin.service

import com.lab.labkotlin.domain.Post
import com.lab.labkotlin.repository.PostRepository
import com.lab.labkotlin.service.inbound.CreatePostInbound
import org.springframework.stereotype.Service

@Service
class PostCommandService(
    val postRepository: PostRepository,
) {
    fun createPost(inbound: CreatePostInbound): Post {
        val newPost = Post.createPost(inbound.title, inbound.content)
        val storedPost = postRepository.save(newPost)
        if(storedPost.id == 0L) {
            throw RuntimeException("Post 생성에 실패했습니다.")
        }
        return storedPost
    }

    fun updatePost(id: Long, title: String, content: String): Post {
//        원래 있던 거 조회해서 변화 없으면 업데이트 안 치게끔 처리
        val existingPost = postRepository.findById(id)
            ?: throw RuntimeException("${id}에 해당하는 Post를 찾을 수 없습니다.")

        val isUpdated = existingPost.update(
            title = title,
            content = content
        )
        if(!isUpdated) {
            throw RuntimeException("${id}에 해당하는 Post는 변경된 내용이 없습니다.")
        }

        return postRepository.update(existingPost)
    }

    fun deleteById(id: Long) {
        val existingPost = postRepository.findById(id)
            ?: throw RuntimeException("${id}에 해당하는 Post를 찾을 수 없습니다.")

        val isDeleted = existingPost.delete()
        if(!isDeleted) {
            throw RuntimeException("${id}에 해당하는 Post는 이미 삭제된 상태입니다.")
        }
        postRepository.delete(existingPost)
    }
}
