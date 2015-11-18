package com.epam.training.pas.dao.impl;

import com.epam.training.pas.dao.UserDao;
import com.epam.training.pas.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
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
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(new User(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3)
            ));
        }

        return users;
    }

    @Override
    public User getUserById(int id) {
        String sql = "SELECT id, username, password FROM users WHERE id = " + id;
        String q = "select id, username, password from users";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
        User u = null;
        if (rs.next()) {
            u = new User(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3)
            );
        }
        return u;
    }

    @Override
    public int save(User user) {
        String sql = "INSERT INTO users (username, password) " +
            "VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "');";
        return jdbcTemplate.update(sql);
    }

    @Override
    public void delete(User user) {
        String sql = "DELETE FROM users WHERE id = " + user.getId() + ";";
        jdbcTemplate.update(sql);

    }

    @Override
    public void delete(int userId) {
        String sql = "DELETE FROM users WHERE id = " + userId + ";";
        jdbcTemplate.update(sql);
    }
}
