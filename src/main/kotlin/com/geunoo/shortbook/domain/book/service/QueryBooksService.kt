package com.geunoo.shortbook.domain.book.service

import com.geunoo.shortbook.global.api.ApiProperties
import com.geunoo.shortbook.global.api.naver.QueryNaverBooksClient
import org.springframework.stereotype.Service

@Service
class QueryBooksService(
    private val queryNaverBooksClient: QueryNaverBooksClient,
    private val apiProperties: ApiProperties,
) {
    fun execute(bookName: String) = queryNaverBooksClient.queryNaverBooks(
        apiProperties.clientId,
        apiProperties.clientSecret,
        bookName,
    )
}