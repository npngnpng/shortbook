package com.geunoo.shortbook.domain.book.controller.dto.response

import java.util.UUID

data class QueryShortBookResponse(
    val books: List<ShortBookResponse>
)

data class ShortBookResponse(
    val id: UUID,
    val title: String,
    val author: String,
    val content: String,
    val imageUrl: String,
)