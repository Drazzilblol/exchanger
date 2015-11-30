package com.epam.training.pas.dao.impl;

import com.epam.training.pas.dao.CurrencyDao;
import com.epam.training.pas.mapper.CurrencyMapper;
import com.epam.training.pas.models.Currency;
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
    public Currency getCurrencyById(Long id) {
        String sql = "SELECT * FROM currency WHERE id = ?";
        Currency currency = jdbcTemplate.queryForObject(sql, new Object[]{id}, new CurrencyMapper());
        return currency;
    }

    @Override
    public Long save(Currency currency) {
        String sql = "INSERT INTO currency (name, currency_code, sale, buy, locked) VALUES (?,?,?,?,?);";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql.toString(), new String[]{"id"});
                ps.setString(1, currency.getName());
                ps.setString(2, currency.getCurrencyCode());
                ps.setDouble(3, currency.getSale());
                ps.setDouble(4, currency.getBuy());
                ps.setBoolean(5, currency.getLocked());
                return ps;
            }
        }, holder);

        return holder.getKey().longValue();

    }

    @Override
    public void update(Currency currency) {
        String sql = "UPDATE currency SET (name, currency_code, sale, buy, locked) = (?,?,?,?,?) WHERE id=?;";
        jdbcTemplate.update(sql, currency.getName(), currency.getCurrencyCode(), currency.getSale(), currency.getBuy(),
                currency.getLocked(), currency.getId());
    }

    @Override
    public int delete(Long currencyId) {
        String sql = "DELETE FROM currency WHERE id = ?";
        return jdbcTemplate.update(sql, currencyId);
    }
}
