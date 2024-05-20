package com.geunoo.shortbook.domain.book.service

import com.geunoo.shortbook.domain.book.controller.dto.response.QueryShortBookResponse
import com.geunoo.shortbook.domain.book.controller.dto.response.ShortBookResponse
import com.geunoo.shortbook.domain.book.entity.repository.BookQueryDSLRepository
import org.springframework.stereotype.Service

@Service
class QueryShortBookService(
    private val bookQueryDSLRepository: BookQueryDSLRepository,
) {

    fun execute() = QueryShortBookResponse(bookQueryDSLRepository.queryBookByRandom().map {
        ShortBookResponse(
            it.id,
            it.name,
            it.author,
            it.content,
            it.bookImageUrl,
        )
    })
}