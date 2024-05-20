package com.geunoo.shortbook.domain.user.service

import com.geunoo.shortbook.domain.user.controller.dto.request.LoginRequest
import com.geunoo.shortbook.domain.user.controller.dto.response.LoginResponse
import com.geunoo.shortbook.domain.user.entity.repository.UserRepository
import com.geunoo.shortbook.global.exception.NotFoundException
import com.geunoo.shortbook.global.exception.UnauthorizedException
import com.gil.easyjwt.jwt.JwtTokenProvider
import com.gil.easyjwt.jwt.TokenType
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class LoginService(
    private val userRepository: UserRepository,
    private val jwtTokenProvider: JwtTokenProvider,
    private val passwordEncoder: PasswordEncoder,
) {
    fun execute(request: LoginRequest): LoginResponse {
        val user = userRepository.findByEmail(request.email)
            ?: throw NotFoundException("User Not Found")

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw UnauthorizedException("Invalid Password")
        }

        return LoginResponse(
            jwtTokenProvider.generateAccessToken(user.id.toString()),
            jwtTokenProvider.getExpiredAt(TokenType.ACCESS),
        )
    }
}