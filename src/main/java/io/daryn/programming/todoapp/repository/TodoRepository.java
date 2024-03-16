package io.daryn.programming.todoapp.repository;

import io.daryn.programming.todoapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUserTodoId(Long userId);
}
