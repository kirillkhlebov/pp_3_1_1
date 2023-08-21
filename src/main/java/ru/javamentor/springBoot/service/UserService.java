package ru.javamentor.springBoot.service;


import ru.javamentor.springBoot.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void deleteUserById(long id);

    List<User> getAllUsers();

    void updateUser(long id, String firstName, String lastName, byte age);

    User findUser(long id);
}
