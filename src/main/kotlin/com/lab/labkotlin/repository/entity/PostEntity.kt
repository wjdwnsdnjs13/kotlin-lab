package com.lab.labkotlin.repository.entity

import com.lab.labkotlin.domain.Post
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotNull
import java.time.Instant

@Entity(name = "posts")
class PostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @NotNull
    @Column(name = "title", length = 200, nullable = false)
    val title: String,

    @Column(name = "content", length = 1000)
    val content: String,

    @Column(name = "created_at")
    val createdAt: Instant,

    @Column(name = "updated_at")
    val updatedAt: Instant,

    @Column(name = "deleted_at")
    val deletedAt: Instant? = null,
    ) {
    companion object{
        fun from(post: Post): PostEntity =
            PostEntity(
                id = post.id,
                title = post.title,
                content = post.content,
                createdAt = post.createdAt,
                updatedAt = post.updatedAt,
                deletedAt = post.deletedAt
            )
    }

    fun toDomain(): Post =
        Post(
            id = this.id,
            title = this.title,
            content = this.content,
            createdAt = this.createdAt!!,
            updatedAt = this.updatedAt!!,
            deletedAt = this.deletedAt
        )
}
