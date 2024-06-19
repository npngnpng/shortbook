package com.geunoo.shortbook.domain.user.controller.dto.request

import jakarta.validation.constraints.NotBlank

data class SignUpRequest(
    @field:NotBlank
    val email: String,
    @field:NotBlank
    val password: String,
    @field:NotBlank
    val name: String,
)
