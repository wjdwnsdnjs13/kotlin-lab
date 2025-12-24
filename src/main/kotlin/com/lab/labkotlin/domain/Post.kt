package com.lab.labkotlin.domain

import java.time.Instant

class Post(
    val id: Long,
    var title: String,
    var content: String,
    val createdAt: Instant,
    var updatedAt: Instant,
    var deletedAt: Instant?
) {
    companion object{
        fun createPost(
            title: String,
            content: String,
        ): Post {
            val now = Instant.now()
            return Post(
                id = 0L,
                title = title,
                content = content,
                createdAt = now,
                updatedAt = now,
                deletedAt = null
            )
        }
    }

    fun update(
        title: String,
        content: String,
    ): Boolean {
        if(this.title.equals(title) && this.content.equals(content)) {
            return false
        }
        this.title = title
        this.content = content
        this.updatedAt = Instant.now()
        return true
    }

    fun delete(): Boolean {
        if(this.deletedAt != null) {
            return false
        }
        this.deletedAt = Instant.now()
        return true
    }
}

