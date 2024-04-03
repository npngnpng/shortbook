package com.geunoo.shortbook.domain.category.controller

import com.geunoo.shortbook.domain.category.controller.dto.request.CreateUserCategoryRequest
import com.geunoo.shortbook.domain.category.service.CreateUserCategoryService
import com.geunoo.shortbook.domain.category.service.QueryCategoriesService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/categories")
@RestController
class CategoryController(
    private val createUserCategoryService: CreateUserCategoryService,
    private val queryCategoriesService: QueryCategoriesService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    fun createUserCategories(
        @RequestBody @Valid request: CreateUserCategoryRequest,
    ) {
        createUserCategoryService.execute(request)
    }

    @GetMapping
    fun queryCategories() = queryCategoriesService.execute()
}