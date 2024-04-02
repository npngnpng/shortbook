package com.geunoo.shortbook.domain.user.service

import com.geunoo.shortbook.domain.user.controller.dto.request.SignUpRequest
import com.geunoo.shortbook.domain.user.entity.User
import com.geunoo.shortbook.domain.user.entity.repository.UserRepository
import com.geunoo.shortbook.global.exception.ConflictException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignUpService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) {
    @Transactional
    fun execute(request: SignUpRequest) {
        if (userRepository.existsByEmail(request.email)) {
            throw ConflictException("User Already Exists")
        }

        userRepository.save(
            User(
                email = request.email,
                password = passwordEncoder.encode(request.password),
                name = request.name,
            )
        )
    }
}