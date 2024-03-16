package io.daryn.programming.todoapp.service;

import io.daryn.programming.todoapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoService{
    List<Todo> findAllTodo();
    Todo findById(Long id);
    Todo saveTodo(Todo todo);
    Todo updateTodo(Todo todo);
    void deleteTodo(Long id);

    List<Todo> findByUserTodoId(Long userId);
}
