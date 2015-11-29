package com.epam.training.pas.mapper;

import com.epam.training.pas.models.Currency;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Drazz on 23.11.2015.
 */
public class CurrencyMapper implements RowMapper<Currency> {
    @Override
    public Currency mapRow(ResultSet rs, int i) throws SQLException {
        Currency currency = new Currency();
        currency.setId(rs.getLong("id"));
        currency.setName(rs.getString("name"));
        currency.setCurrencyCode(rs.getString("currency_code"));
        currency.setBuy(rs.getDouble("buy"));
        currency.setSale(rs.getDouble("sale"));
        return currency;
    }
}
