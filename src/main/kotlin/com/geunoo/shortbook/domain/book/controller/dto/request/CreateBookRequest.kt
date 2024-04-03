package com.geunoo.shortbook.domain.book.controller.dto.request

import java.util.UUID

data class CreateBookRequest(
    val review: String,
    val categoryIds: List<UUID>,
)
