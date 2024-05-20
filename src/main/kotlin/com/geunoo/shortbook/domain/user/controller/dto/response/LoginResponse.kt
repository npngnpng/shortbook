package com.geunoo.shortbook.domain.user.controller.dto.response

import java.time.LocalDateTime

data class LoginResponse(
    val accessToken: String,
    val expiredAt: LocalDateTime,
)
