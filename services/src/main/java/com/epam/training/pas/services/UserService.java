package com.epam.training.pas.services;

import com.epam.training.pas.models.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Drazz on 16.11.2015.
 */
public interface UserService extends Serializable {
    public List<User> getUsers();

    public User getUserById(Long id);

    public Long save(User user);

    public void update(User user);

    public int delete(Long userId);
}
