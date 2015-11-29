package com.epam.training.pas.dao;

import com.epam.training.pas.models.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Drazz on 16.11.2015.
 */
public interface UserDao extends Serializable {

    List<User> getUsers();

    User getUserById(int id);

    void save(User user);

    void delete(int userId);
}
