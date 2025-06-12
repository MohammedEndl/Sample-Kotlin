package oVRlab.io.users.Model

import jakarta.persistence.*

@Entity
@Table(name = "users") // تجنب الكلمة المحجوزة "user"
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    var name: String,
    var email: String
)

