package com.geunoo.shortbook.domain.book.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
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

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(400)")
    val content: String,
)