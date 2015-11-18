package com.epam.training.pas.dao;

import com.epam.training.pas.models.User;

import java.util.List;

/**
 * Created by Drazz on 16.11.2015.
 */
public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    int save(User user);

    void delete(User user);

    void delete(int userId);
}
