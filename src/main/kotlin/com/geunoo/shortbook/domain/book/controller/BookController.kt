package com.geunoo.shortbook.domain.book.controller

import com.geunoo.shortbook.domain.book.controller.dto.request.CreateBookRequest
import com.geunoo.shortbook.domain.book.controller.dto.response.QueryShortBookResponse
import com.geunoo.shortbook.domain.book.controller.dto.response.ShortBookResponse
import com.geunoo.shortbook.domain.book.service.CreateBookService
import com.geunoo.shortbook.domain.book.service.QueryBooksService
import com.geunoo.shortbook.domain.book.service.QueryShortBookService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/books")
@RestController
class BookController(
    private val queryBooksService: QueryBooksService,
    private val createBookService: CreateBookService,
    private val queryShortBookService: QueryShortBookService,
) {

    @GetMapping
    fun queryBooks(@RequestParam("name") name: String) = queryBooksService.execute(name)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{isbn}")
    fun shareBook(
        @PathVariable isbn: String,
        @RequestBody @Valid request: CreateBookRequest,
    ) {
        createBookService.execute(isbn, request)
    }

    @GetMapping("/short")
    fun queryShortBook(): QueryShortBookResponse {
        return queryShortBookService.execute()
    }
}