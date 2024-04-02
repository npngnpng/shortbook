package com.geunoo.shortbook.domain.category.entity.repository

import com.geunoo.shortbook.domain.category.entity.BookCategory
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface BookCategoryRepository : JpaRepository<BookCategory, UUID> {
}