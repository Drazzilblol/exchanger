package com.epam.training.pas.services;

import com.epam.training.pas.models.User;

/**
 * Created by Drazz on 16.11.2015.
 */
public interface UserService {

    public User getUserById(int id);

    public int save(User user);

    public void delete(User user);

    void deleteById(int userId);
}
