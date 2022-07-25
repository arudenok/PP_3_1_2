package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    User getUser(int id);

    User getUserByUsername(String name);

    List<User> showUser();

   void saveUser(User user);

   void updateUser(int id, User user);

    void removeUser(int id);


}
