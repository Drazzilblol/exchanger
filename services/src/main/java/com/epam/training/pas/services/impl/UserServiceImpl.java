package com.epam.training.pas.services.impl;

import com.epam.training.pas.dao.UserDao;
import com.epam.training.pas.models.User;
import com.epam.training.pas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Drazz on 16.11.2015.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void save(User user) {
         userDao.save(user);
    }

    @Override
    public void delete(int userId) {
        userDao.delete(userId);
    }
}
