package w.auth.user

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Account (
    var username: String,
    var password: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0L,
)