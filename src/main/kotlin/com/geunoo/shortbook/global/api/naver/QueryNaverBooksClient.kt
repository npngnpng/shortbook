package com.geunoo.shortbook.global.api.naver

import com.geunoo.shortbook.global.api.naver.dto.QueryNaverBookResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "NaverBook", url = "https://openapi.naver.com/v1/search/book.json")
interface QueryNaverBooksClient {

    @GetMapping
    fun queryNaverBooks(
        @RequestHeader("X-Naver-Client-Id") clientId: String,
        @RequestHeader("X-Naver-Client-Secret") clientSecret: String,
        @RequestParam("query") name: String,
        @RequestParam("display", required = false) display: Int? = null,
        @RequestParam("start", required = false) start: Int? = null,
        @RequestParam("sort", required = false) sort: String? = null
    ): QueryNaverBookResponse
}