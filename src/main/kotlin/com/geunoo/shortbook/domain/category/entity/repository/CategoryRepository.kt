package com.geunoo.shortbook.domain.category.entity.repository

import com.geunoo.shortbook.domain.category.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CategoryRepository : JpaRepository<Category, UUID> {

    fun findAllByIdIn(categoryIds: List<UUID>): List<Category>
}