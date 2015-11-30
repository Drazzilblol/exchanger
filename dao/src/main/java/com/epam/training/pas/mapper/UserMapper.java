package com.epam.training.pas.mapper;

/**
 * Created by Drazz on 23.11.2015.
 */

import com.epam.training.pas.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setUserProfileId(rs.getLong("user_profile_id"));
        user.setAdmin(rs.getBoolean("is_admin"));
        return user;
    }
}
