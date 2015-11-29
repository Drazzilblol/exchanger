package com.epam.training.pas.dao.impl;

import com.epam.training.pas.dao.UserDao;
import com.epam.training.pas.mapper.UserMapper;
import com.epam.training.pas.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
        String sql = "select * from users";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        return users;
    }

    @Override
    public User getUserById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        User u = jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper());
        return u;
    }

    @Override
    public Long save(User user) {
        String sql = "INSERT INTO users (username, password, user_profile_id) VALUES (?,?,?);";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql.toString(), new String[] {"id"});
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setLong(3, user.getUserProfileId());
                return ps;
            }
        }, holder);

        return  holder.getKey().longValue();
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET (username, password, user_profile_id) = (?,?,?) WHERE id = ?;";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getUserProfileId(), user.getId());
    }


    @Override
    public int delete(Long userId) {
        String sql = "DELETE FROM users WHERE id = ?";
        return jdbcTemplate.update(sql, userId);
    }
}
