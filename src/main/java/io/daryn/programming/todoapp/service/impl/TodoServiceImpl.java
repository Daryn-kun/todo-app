package io.daryn.programming.todoapp.service.impl;

import io.daryn.programming.todoapp.entity.Todo;
import io.daryn.programming.todoapp.repository.TodoRepository;
import io.daryn.programming.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findAllTodo() {
        return todoRepository.findAll();
    }

    @Override
    public List<Todo> findByUserTodoId(Long userId) {
        return todoRepository.findByUserTodoId(userId);
    }

    @Override
    public Todo findById(Long id) {
        Todo todo = null;
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isPresent()){
            todo = optionalTodo.get();
        } else {
            System.out.println("Error todo");
        }

        return todo;
    }

    @Override
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
