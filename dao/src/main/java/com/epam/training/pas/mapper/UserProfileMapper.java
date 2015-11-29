package com.epam.training.pas.mapper;

import com.epam.training.pas.models.UserProfile;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Drazz on 23.11.2015.
 */
public class UserProfileMapper implements RowMapper<UserProfile> {
    @Override
    public UserProfile mapRow(ResultSet rs, int i) throws SQLException {
        UserProfile userProfile = new UserProfile();
        userProfile.setId(rs.getLong("id"));
        userProfile.setFirstName(rs.getString("first_name"));
        userProfile.setLastName(rs.getString("last_name"));
        userProfile.setEmail(rs.getString("email"));
        userProfile.setPassportNumber(rs.getString("passport_number"));
        userProfile.setCountryId(rs.getLong("country_id"));
        return userProfile;
    }
}
