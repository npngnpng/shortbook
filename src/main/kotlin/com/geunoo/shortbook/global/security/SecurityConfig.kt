package com.geunoo.shortbook.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.geunoo.shortbook.domain.user.entity.User
import com.geunoo.shortbook.global.exception.ExceptionFilter
import com.gil.easyjwt.jwt.JwtFilter
import com.gil.easyjwt.jwt.JwtTokenProvider
import com.gil.easyjwt.user.CurrentUserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class SecurityConfig(
    private val objectMapper: ObjectMapper,
    private val jwtTokenProvider: JwtTokenProvider
) {

    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .formLogin { it.disable() }
            .formLogin { it.disable() }
            .csrf { it.disable() }
            .cors {}
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .authorizeHttpRequests {
                it
                    // category
                    .requestMatchers(HttpMethod.POST, "categories/user").authenticated()

                    // user
                    .requestMatchers(HttpMethod.POST, "/users").permitAll()
                    .requestMatchers(HttpMethod.POST, "/users/login").permitAll()
                    .anyRequest().authenticated()
            }
            .addFilterBefore(JwtFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter::class.java)
            .addFilterBefore(ExceptionFilter(objectMapper), JwtFilter::class.java)
            .build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun currentUserService(): CurrentUserService<User> = CurrentUserService()
}