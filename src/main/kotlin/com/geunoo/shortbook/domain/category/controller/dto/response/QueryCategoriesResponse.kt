package com.geunoo.shortbook.domain.category.controller.dto.response

import java.util.UUID

data class QueryCategoriesResponse(
    val categories: List<CategoryResponse>,
)

data class CategoryResponse(
    val id: UUID,
    val name: String,
)