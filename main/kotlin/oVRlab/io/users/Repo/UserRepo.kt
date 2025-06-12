package oVRlab.io.users.Repo

import oVRlab.io.users.Model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
