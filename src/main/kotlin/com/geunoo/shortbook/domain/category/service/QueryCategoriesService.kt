package com.geunoo.shortbook.domain.category.service

import com.geunoo.shortbook.domain.category.controller.dto.response.CategoryResponse
import com.geunoo.shortbook.domain.category.controller.dto.response.QueryCategoriesResponse
import com.geunoo.shortbook.domain.category.entity.repository.CategoryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryCategoriesService(
    private val categoryRepository: CategoryRepository,
) {

    @Transactional(readOnly = true)
    fun execute(): QueryCategoriesResponse = QueryCategoriesResponse(categoryRepository.findAll().map {
        CategoryResponse(it.id, it.name)
    })
}