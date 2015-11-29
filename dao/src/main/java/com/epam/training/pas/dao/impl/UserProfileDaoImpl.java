package com.epam.training.pas.dao.impl;

import com.epam.training.pas.dao.UserProfileDao;
import com.epam.training.pas.mapper.UserProfileMapper;
import com.epam.training.pas.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public class UserProfileDaoImpl implements UserProfileDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<UserProfile> getProfiles() {
        String sql = "SELECT * FROM user_profile";
        List<UserProfile> profiles = jdbcTemplate.query(sql, new UserProfileMapper());
        return profiles;
    }

    @Override
    public UserProfile getUserProfileById(int id) {
        String sql = "SELECT * FROM user_profile WHERE id = ?";
        UserProfile profile = jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserProfileMapper());
        return profile;
    }

    @Override
    public void save(UserProfile userProfile) {
        String sql = "INSERT INTO user_profile (first_name, last_name, country_id, passport_number, email) VALUES (?,?,?,?,?);";
        jdbcTemplate.update(sql, userProfile.getFirstName(), userProfile.getLastName(), userProfile.getCountryId(),
            userProfile.getPassportNumber(), userProfile.getEmail());
    }

    @Override
    public void delete(int userProfileId) {
        String sql = "DELETE FROM user_profile WHERE id = ?";
        jdbcTemplate.update(sql, userProfileId);
    }
}
