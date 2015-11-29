package com.epam.training.pas.dao.impl;

import com.epam.training.pas.dao.CountryDao;
import com.epam.training.pas.mapper.CountryMapper;
import com.epam.training.pas.models.Country;
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
public class CountryDaoImpl implements CountryDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Country> getCountryList() {
        String sql = "select * from country";
        List<Country> countries = jdbcTemplate.query(sql, new CountryMapper());
        return countries;
    }

    @Override
    public Country getCountry(Long id) {
        String sql = "SELECT * FROM country WHERE id = ?";
        Country country = jdbcTemplate.queryForObject(sql, new Object[]{id}, new CountryMapper());
        return country;
    }

    @Override
    public Long save(Country country) {
        String sql = "INSERT INTO country (name, country_code) VALUES (?,?);";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql.toString(), new String[] {"id"});
                ps.setString(1, country.getName());
                ps.setString(2, country.getCountryCode());
                return ps;
            }
        }, holder);

        return  holder.getKey().longValue();
    }

    @Override
    public void update(Country country) {
        String sql = "UPDATE country SET (name, country_code) = (?,?) WHERE id=?;";
        jdbcTemplate.update(sql, country.getName(), country.getCountryCode(), country.getId());
    }


    @Override
    public int delete(Long countryId) {
        String sql = "DELETE FROM country WHERE id = ?";
        return jdbcTemplate.update(sql, countryId);

    }
}
