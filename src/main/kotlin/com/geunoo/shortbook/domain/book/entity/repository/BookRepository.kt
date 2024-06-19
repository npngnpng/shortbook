package com.geunoo.shortbook.domain.book.entity.repository

import com.geunoo.shortbook.domain.book.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface BookRepository : JpaRepository<Book, UUID> {
    fun findAllByUserId(userId: UUID): List<Book>
}