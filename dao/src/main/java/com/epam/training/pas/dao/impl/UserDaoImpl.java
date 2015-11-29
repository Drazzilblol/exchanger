package com.epam.training.pas.dao.impl;

import com.epam.training.pas.dao.UserDao;
import com.epam.training.pas.mapper.UserMapper;
import com.epam.training.pas.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Drazz on 16.11.2015.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> getUsers() {
        String sql = "select id, username, password from users";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        return users;
    }

    @Override
    public User getUserById(int id) {
        String sql = "SELECT id, username, password FROM users WHERE id = ?";
        User u = jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper());
        return u;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (username, password) VALUES (?,?);";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }


    @Override
    public void delete(int userId) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, userId);
    }
}
