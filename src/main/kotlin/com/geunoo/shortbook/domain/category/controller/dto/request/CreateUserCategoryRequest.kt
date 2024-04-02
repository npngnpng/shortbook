package com.geunoo.shortbook.domain.category.controller.dto.request

import java.util.UUID

data class CreateUserCategoryRequest(
    val categoryIds: List<UUID>
)
