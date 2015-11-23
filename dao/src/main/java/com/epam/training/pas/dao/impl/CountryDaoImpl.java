package com.epam.training.pas.dao.impl;

import com.epam.training.pas.dao.CountryDao;
import com.epam.training.pas.mapper.CountryMapper;
import com.epam.training.pas.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public class CountryDaoImpl implements CountryDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Country> getCountryList() {
        String sql = "select id, name, country_code from country";
        List<Country> countries = jdbcTemplate.query(sql, new CountryMapper());
        return countries;
    }

    @Override
    public Country getCountry(int id) {
        String sql = "SELECT id, name, country_code FROM country WHERE id = ?";
        Country country = jdbcTemplate.queryForObject(sql, new Object[]{id}, new CountryMapper());
        return country;
    }

    @Override
    public int save(Country country) {
        String sql = "INSERT INTO country (name, country_code) VALUES (?,?);";
        return jdbcTemplate.update(sql, country.getName(), country.getCountryCode());
    }

    @Override
    public void delete(Country country) {
        String sql = "DELETE FROM country WHERE id = ?;";
        jdbcTemplate.update(sql, country.getId());

    }

    @Override
    public void delete(int countryId) {
        String sql = "DELETE FROM country WHERE id = ?";
        jdbcTemplate.update(sql, countryId);

    }
}
