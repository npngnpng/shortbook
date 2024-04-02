package com.geunoo.shortbook.domain.category.entity.repository

import com.geunoo.shortbook.domain.category.entity.UserCategory
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserCategoryRepository : JpaRepository<UserCategory, UUID> {
}