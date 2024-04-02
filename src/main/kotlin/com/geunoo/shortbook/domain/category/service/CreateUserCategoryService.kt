package com.geunoo.shortbook.domain.category.service

import com.geunoo.shortbook.domain.category.controller.dto.request.CreateUserCategoryRequest
import com.geunoo.shortbook.domain.category.entity.UserCategory
import com.geunoo.shortbook.domain.category.entity.repository.CategoryRepository
import com.geunoo.shortbook.domain.category.entity.repository.UserCategoryRepository
import com.geunoo.shortbook.domain.user.entity.User
import com.geunoo.shortbook.domain.user.entity.repository.UserRepository
import com.gil.easyjwt.user.CurrentUserService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateUserCategoryService(
    private val userRepository: UserRepository,
    private val categoryRepository: CategoryRepository,
    private val userCategoryRepository: UserCategoryRepository,
    private val currentUserService: CurrentUserService<User>,
) {

    @Transactional
    fun execute(request: CreateUserCategoryRequest) {
        val user = currentUserService.currentUser
        val categories = categoryRepository.findAllByIdIn(request.categoryIds)

        userCategoryRepository.saveAll(
            categories.map {
                UserCategory(
                    user = user,
                    category = it
                )
            }
        )
    }
}