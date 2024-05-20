package com.geunoo.shortbook.domain.book.entity.repository

import com.geunoo.shortbook.domain.book.entity.Book
import com.geunoo.shortbook.domain.book.entity.QBook.book
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.core.types.dsl.Expressions
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class BookQueryDSLRepository(
    private val queryFactory: JPAQueryFactory
) {

    fun queryBookByRandom(): List<Book> {
        return queryFactory
            .selectFrom(book)
            .orderBy(Expressions.numberTemplate(Double::class.java, "function('rand')").asc())
            .fetch();
    }
}