package io.daryn.programming.todoapp.service;

import io.daryn.programming.todoapp.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    User findById(Long id);
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
}
