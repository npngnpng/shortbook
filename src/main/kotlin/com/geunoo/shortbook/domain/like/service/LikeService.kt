package com.geunoo.shortbook.domain.like.service

import com.geunoo.shortbook.domain.book.entity.repository.BookRepository
import com.geunoo.shortbook.domain.like.entity.Likes
import com.geunoo.shortbook.domain.like.entity.repository.LikesRepository
import com.geunoo.shortbook.domain.user.entity.User
import com.geunoo.shortbook.global.exception.NotFoundException
import com.gil.easyjwt.user.CurrentUserService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class LikeService(
    private val likesRepository: LikesRepository,
    private val bookRepository: BookRepository,
    private val currentUserService: CurrentUserService<User>
) {
    @Transactional
    fun execute(bookId: UUID) {
        val user = currentUserService.currentUser
        val book = bookRepository.findByIdOrNull(bookId) ?: throw NotFoundException("Book Not Found")
        likesRepository.findByBookIdAndUserId(book.id, user.id)?.let {
            likesRepository.delete(it)
        } ?: likesRepository.save(
            Likes(
                book = book,
                user = user,
            )
        )
    }
}