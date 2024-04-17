package com.geunoo.shortbook.domain.user.controller

import com.geunoo.shortbook.domain.user.controller.dto.request.LoginRequest
import com.geunoo.shortbook.domain.user.controller.dto.request.SignUpRequest
import com.geunoo.shortbook.domain.user.controller.dto.response.LoginResponse
import com.geunoo.shortbook.domain.user.service.LoginService
import com.geunoo.shortbook.domain.user.service.SignUpService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserController(
    private val signUpService: SignUpService,
    private val loginService: LoginService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun signup(
        @RequestBody @Valid request: SignUpRequest,
    ) {
        signUpService.execute(request)
    }

    @PostMapping("/login")
    fun login(
        @RequestBody @Valid request: LoginRequest,
    ) : LoginResponse = loginService.execute(request)
}