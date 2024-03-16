package io.daryn.programming.todoapp.controller;

import io.daryn.programming.todoapp.entity.Todo;
import io.daryn.programming.todoapp.entity.User;
import io.daryn.programming.todoapp.service.TodoService;
import io.daryn.programming.todoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final TodoService todoService;

    @Autowired
    public UserController(UserService userService, TodoService todoService) {
        this.userService = userService;
        this.todoService = todoService;
    }

    @GetMapping
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }

    @GetMapping("/{userId}")
    public User findUserById(@PathVariable Long userId){
        return userService.findById(userId);
    }

    @PostMapping("/{userId}/todos")
    public void addTodo(@PathVariable Long userId, @RequestBody Todo todo){
        User user = userService.findById(userId);
        todo.setUserTodo(user);
        todoService.saveTodo(todo);
    }

    @PostMapping("/todos/{todosId}")
    public void setTodoCompleted(@PathVariable Long todosId){
        Todo todo = todoService.findById(todosId);
        todo.setCompleted(!todo.getCompleted());
        todoService.saveTodo(todo);
    }

    @DeleteMapping("/todos/{todosId}")
    public void deleteTodo(@PathVariable Long todosId){
        Todo todo = todoService.findById(todosId);
        todoService.deleteTodo(todo.getId());
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        User user = userService.findById(userId);
        userService.deleteUser(user.getId());
    }
}
