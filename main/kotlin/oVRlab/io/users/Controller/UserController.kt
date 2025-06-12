package oVRlab.io.users.Controller

import oVRlab.io.users.Model.User
import oVRlab.io.users.Service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>?> {
        val users = userService.getAllUsers()
        return ResponseEntity.ok(users)
    }

    @PostMapping
    fun createUser(@RequestBody users: User): ResponseEntity<User> {
        val savedUser = userService.createUser(users)
        return ResponseEntity.ok(savedUser)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: User): ResponseEntity<User> {
        val updated = userService.updateUser(id, user)
        return if (updated != null) ResponseEntity.ok(updated)
        else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        val deleted = userService.deleteUser(id)
        return if (deleted) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }
}

private fun UserService.getAllUsers() {

}
