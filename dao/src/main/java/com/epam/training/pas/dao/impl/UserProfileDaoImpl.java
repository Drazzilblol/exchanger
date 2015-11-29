package com.epam.training.pas.dao.impl;

import com.epam.training.pas.dao.UserProfileDao;
import com.epam.training.pas.mapper.UserProfileMapper;
import com.epam.training.pas.models.UserProfile;
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
import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
@Repository
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
    public UserProfile getUserProfileById(Long id) {
        String sql = "SELECT * FROM user_profile WHERE id = ?";
        UserProfile profile = jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserProfileMapper());
        return profile;
    }

    @Override
    public Long save(UserProfile userProfile) {
        String sql = "INSERT INTO user_profile (first_name, last_name, country_id, passport_number, email, user_id)" +
                " VALUES (?,?,?,?,?,?);";

        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql.toString(), new String[] {"id"});
                ps.setString(1, userProfile.getFirstName());
                ps.setString(2, userProfile.getLastName());
                ps.setLong(3, userProfile.getCountryId());
                ps.setString(4, userProfile.getPassportNumber());
                ps.setString(5, userProfile.getEmail());
                ps.setLong(6, userProfile.getUserId());
                return ps;
            }
        }, holder);

        return  holder.getKey().longValue();
    }

    @Override
    public void update(UserProfile userProfile) {
        String sql = "UPDATE user_profile SET (first_name, last_name, country_id, passport_number, email, user_id) = (?,?,?,?,?,?) WHERE id = ?;";
        jdbcTemplate.update(sql, userProfile.getFirstName(), userProfile.getLastName(), userProfile.getCountryId(),
                userProfile.getPassportNumber(), userProfile.getEmail(), userProfile.getUserId(), userProfile.getId());
    }

    @Override
    public int delete(Long userProfileId) {
        String sql = "DELETE FROM user_profile WHERE id = ?";
        return jdbcTemplate.update(sql, userProfileId);
    }
}
