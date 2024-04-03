package com.geunoo.shortbook.domain.book.entity

import com.geunoo.shortbook.domain.user.entity.User
import jakarta.persistence.Column
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
class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID(0, 0),

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(30)")
    val name: String,

    @Column(columnDefinition = "VARCHAR(255)")
    val bookImageUrl: String,

    @Column(columnDefinition = "VARCHAR(255)")
    val link: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(4000)")
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,
)