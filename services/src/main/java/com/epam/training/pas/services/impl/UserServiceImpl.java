package com.epam.training.pas.services.impl;

import com.epam.training.pas.dao.UserDao;
import com.epam.training.pas.models.User;
import com.epam.training.pas.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Drazz on 16.11.2015.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public Long save(User user) {
        LOGGER.info("Save user {}", user.getUsername());
        return userDao.save(user);
    }

    @Override
    public void update(User user) {
        LOGGER.info("update user {}", user.getUsername());
        userDao.update(user);
    }

    @Override
    public int delete(Long userId) {
        LOGGER.info("Delete user wuth id = {}", userId);
        return userDao.delete(userId);
    }
}
