package com.geunoo.shortbook.domain.like.entity

import com.geunoo.shortbook.domain.book.entity.Book
import com.geunoo.shortbook.domain.user.entity.User
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.jetbrains.annotations.NotNull
import java.util.UUID

@Entity
class Likes(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,

    @field:NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    @field:NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    val book: Book,
)