package ru.javamentor.springBoot.dao;


import ru.javamentor.springBoot.model.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    void deleteUser(User user);

    List<User> getAllUsers();

    void updateUser(long id, String firstName, String lastName, byte age);

    User fingUser(long id);

}
