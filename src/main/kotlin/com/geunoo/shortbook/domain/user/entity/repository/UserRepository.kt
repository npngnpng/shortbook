package com.geunoo.shortbook.domain.user.entity.repository

import com.geunoo.shortbook.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<User, UUID> {
    fun findByEmail(email: String): User?
}