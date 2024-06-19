package com.geunoo.shortbook.domain.book.service

import com.geunoo.shortbook.domain.book.controller.dto.response.QueryShortBookResponse
import com.geunoo.shortbook.domain.book.controller.dto.response.ShortBookResponse
import com.geunoo.shortbook.domain.book.entity.repository.BookRepository
import com.geunoo.shortbook.domain.user.entity.User
import com.gil.easyjwt.user.CurrentUserService
import org.springframework.stereotype.Service

@Service
class QueryMyBooksService(
    private val bookRepository: BookRepository,
    private val currentUserService: CurrentUserService<User>
) {
    fun execute(): QueryShortBookResponse {
        val user = currentUserService.currentUser
        return QueryShortBookResponse(
            bookRepository.findAllByUserId(user.id).map {
                ShortBookResponse(
                    id = it.id,
                    title = it.name,
                    author = it.author,
                    content = it.content,
                    imageUrl = it.bookImageUrl
                )
            }
        )
    }
}