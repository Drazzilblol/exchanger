package com.epam.training.pas.services.impl;

import com.epam.training.pas.dao.UserDao;
import com.epam.training.pas.models.User;
import com.epam.training.pas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Drazz on 16.11.2015.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public int save(User user) {
        return userDao.save(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void deleteById(int userId) {
        userDao.deleteById(userId);
    }
}
