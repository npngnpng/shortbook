package com.geunoo.shortbook.domain.like.controller

import com.geunoo.shortbook.domain.like.service.LikeService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("/likes")
@RestController
class LikeController(
    private val likeService: LikeService,
) {

    @PutMapping("/{book-id}")
    fun like(@PathVariable("book-id") bookId: UUID) {
        likeService.execute(bookId)
    }
}