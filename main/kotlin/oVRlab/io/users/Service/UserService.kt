package oVRlab.io.users.Service
import oVRlab.io.users.Model.User
import oVRlab.io.users.Repo.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun createUser(user: User): User = userRepository.save(user)

    fun updateUser(id: Long, updatedUser: User): User? {
        val users = userRepository.findById(id).orElse(null) ?: return null
        users.name = updatedUser.name
        users.email = updatedUser.email
        return userRepository.save(users)
    }

    fun deleteUser(id: Long): Boolean {
        return if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
            true
        } else {
            false
        }
    }
    fun getAllUsers(): List<User> = userRepository.findAll()
}
