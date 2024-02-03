package w.auth.user

import jakarta.annotation.PostConstruct
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.User.UserBuilder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import kotlin.math.acos

@Service
class AccountService(
    private val accountRepsotiroy: AccountRepsotiroy,
    private val passwordEncoder: PasswordEncoder
) : UserDetailsService{

    @PostConstruct
    fun initInsert() {
        saveUser("user", "1234")
    }

    fun saveUser(username: String, password: String) {
        val encodedPassword = passwordEncoder.encode(password)
        val account = Account(username, encodedPassword)

        accountRepsotiroy.save(account)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val account = accountRepsotiroy.findByUsername(username) ?: throw UsernameNotFoundException("username = ${username}")

        return User.builder()
            .username(account.username)
            .password(account.password)
            .roles("USER")
            .build()
    }
}