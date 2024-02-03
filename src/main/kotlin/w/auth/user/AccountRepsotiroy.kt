package w.auth.user

import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepsotiroy : JpaRepository<Account, Long> {
    fun findByUsername(username: String?) : Account?
}

