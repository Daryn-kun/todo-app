package io.daryn.programming.todoapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(
            mappedBy = "userTodo",
            cascade = {CascadeType.ALL}
    )
    @JsonManagedReference
    private List<Todo> todoList;

    public User() {
    }

    public User(Long id, String username, String password, List<Todo> todoList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.todoList = todoList;
    }

    public Long getId() {
        return id;
    }

    public void addTodo(Todo todo) {
        if (this.todoList == null) {
            this.todoList = new ArrayList();
        }

        this.todoList.add(todo);
        todo.setUserTodo(this);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }
}
