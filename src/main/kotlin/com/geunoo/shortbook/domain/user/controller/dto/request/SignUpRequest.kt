package com.geunoo.shortbook.domain.user.controller.dto.request

data class SignUpRequest(
    val email: String,
    val password: String,
    val name: String,
)
