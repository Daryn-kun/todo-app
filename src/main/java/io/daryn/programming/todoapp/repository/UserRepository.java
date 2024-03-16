package io.daryn.programming.todoapp.repository;

import io.daryn.programming.todoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
