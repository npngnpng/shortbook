package com.geunoo.shortbook.domain.user.entity

import com.gil.easyjwt.user.JwtUser
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.jetbrains.annotations.NotNull
import org.springframework.security.core.GrantedAuthority
import java.util.UUID

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID(0, 0),

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(30)")
    val email: String,

    @field:NotNull
    @Column(columnDefinition = "CHAR(60)")
    val password: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(30)")
    val name: String,
) : JwtUser() {
    override fun getUsername() = email

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = mutableListOf()
}