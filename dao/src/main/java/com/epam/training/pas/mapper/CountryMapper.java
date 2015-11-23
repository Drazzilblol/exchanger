package com.epam.training.pas.mapper;

import com.epam.training.pas.models.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Drazz on 23.11.2015.
 */
public class CountryMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet rs, int i) throws SQLException {
        Country country = new Country();
        country.setId(rs.getLong("id"));
        country.setName(rs.getString("name"));
        country.setCountryCode(rs.getString("country_code"));
        return country;
    }
}
