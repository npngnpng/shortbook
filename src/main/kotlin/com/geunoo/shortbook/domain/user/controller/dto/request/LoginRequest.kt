package com.geunoo.shortbook.domain.user.controller.dto.request

data class LoginRequest(
    val email: String,
    val password: String,
)
