package com.geunoo.shortbook.global.security

import com.geunoo.shortbook.domain.user.entity.repository.UserRepository
import com.gil.easyjwt.user.JwtUser
import com.gil.easyjwt.user.QueryJwtUserService
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class JwtUserDetailsService(
    private val userRepository: UserRepository,
) : QueryJwtUserService {

    override fun execute(email: String): Optional<JwtUser> {
        val user = userRepository.findByEmail(email)
        return if (user == null) {
            Optional.empty()
        } else {
            Optional.of(user as JwtUser)
        }
    }
}