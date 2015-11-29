package com.epam.training.pas.dao;

import com.epam.training.pas.models.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Drazz on 16.11.2015.
 */
public interface UserDao extends Serializable {

    List<User> getUsers();

    User getUserById(Long id);

    Long save(User user);

    void update(User user);

    int delete(Long userId);
}
