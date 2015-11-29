package com.epam.training.pas.dao.impl;

import com.epam.training.pas.dao.CurrencyDao;
import com.epam.training.pas.mapper.CurrencyMapper;
import com.epam.training.pas.models.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public class CurrencyDaoImpl implements CurrencyDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Currency> getCurrencies() {
        String sql = "select * from currency";
        List<Currency> currencyList = jdbcTemplate.query(sql, new CurrencyMapper());
        return currencyList;
    }

    @Override
    public Currency getCurrencyById(int id) {
        String sql = "SELECT * FROM currency WHERE id = ?";
        Currency currency = jdbcTemplate.queryForObject(sql, new Object[]{id}, new CurrencyMapper());
        return null;
    }

    @Override
    public void save(Currency currency) {
        String sql = "INSERT INTO currency (name, currency_code, sale, buy) VALUES (?,?, ?, ?);";
        jdbcTemplate.update(sql, currency.getName(), currency.getCurrencyCode(), currency.getSale(), currency.getBuy());

    }

    @Override
    public void delete(int currencyId) {
        String sql = "DELETE FROM currency WHERE id = ?";
        jdbcTemplate.update(sql, currencyId);

    }
}
