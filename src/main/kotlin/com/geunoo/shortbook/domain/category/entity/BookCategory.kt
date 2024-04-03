package com.geunoo.shortbook.domain.category.entity

import com.geunoo.shortbook.domain.book.entity.Book
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
class BookCategory(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID(0, 0),

    @field:NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    val book: Book,

    @field:NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    val category: Category,
)