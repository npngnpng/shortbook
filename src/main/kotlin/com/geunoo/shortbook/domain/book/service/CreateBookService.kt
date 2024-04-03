package com.geunoo.shortbook.domain.book.service

//import com.geunoo.shortbook.domain.book.controller.dto.request.CreateBookRequest
import com.geunoo.shortbook.domain.book.controller.dto.request.CreateBookRequest
import com.geunoo.shortbook.domain.book.entity.Book
import com.geunoo.shortbook.domain.book.entity.repository.BookRepository
import com.geunoo.shortbook.domain.category.entity.BookCategory
import com.geunoo.shortbook.domain.category.entity.repository.BookCategoryRepository
import com.geunoo.shortbook.domain.category.entity.repository.CategoryRepository
import com.geunoo.shortbook.domain.user.entity.User
import com.geunoo.shortbook.global.api.ApiProperties
import com.geunoo.shortbook.global.api.naver.QueryNaverBooksClient
import com.gil.easyjwt.user.CurrentUserService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateBookService(
    private val bookRepository: BookRepository,
    private val categoryRepository: CategoryRepository,
    private val bookCategoryRepository: BookCategoryRepository,
    private val queryNaverBooksClient: QueryNaverBooksClient,
    private val apiProperties: ApiProperties,
    private val currentUserService: CurrentUserService<User>
) {
    @Transactional
    fun execute(isbn: String, request: CreateBookRequest) {
        val user = currentUserService.currentUser
        val categories = categoryRepository.findAllByIdIn(request.categoryIds)
        val bookInfo = queryNaverBooksClient.queryNaverBooks(
            apiProperties.clientId,
            apiProperties.clientSecret,
            isbn
        ).items[0]

        val book = bookRepository.save(
            Book(
                name = bookInfo.title,
                bookImageUrl = bookInfo.image,
                link = bookInfo.link,
                content = "${bookInfo.description}\n 한줄평 \n ${request.review}",
                user = user,
            )
        )

        bookCategoryRepository.saveAll(
            categories.map {
                BookCategory(
                    book = book,
                    category = it,
                )
            }
        )
    }
}