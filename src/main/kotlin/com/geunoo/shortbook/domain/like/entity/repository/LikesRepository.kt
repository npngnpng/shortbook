package com.geunoo.shortbook.domain.like.entity.repository

import com.geunoo.shortbook.domain.like.entity.Likes
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface LikesRepository : CrudRepository<Likes, UUID> {

    fun findByBookIdAndUserId(bookId: UUID, userId: UUID): Likes?
}
