package com.epam.training.pas.dao.impl;

import com.epam.training.pas.dao.OperationDao;
import com.epam.training.pas.mapper.OperationMapper;
import com.epam.training.pas.models.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
@Repository
public class OperationDaoImpl implements OperationDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Operation> getOperations() {
        String sql = "SELECT * FROM operation";
        List<Operation> operations = jdbcTemplate.query(sql, new OperationMapper());
        return operations;
    }

    @Override
    public Operation getOperationById(Long id) {
        String sql = "SELECT * FROM operation WHERE id = ?";
        Operation operation = jdbcTemplate.queryForObject(sql, new Object[]{id}, new OperationMapper());
        return operation;
    }

    @Override
    public Long save(Operation operation) {
        String sql = "INSERT INTO operation (currency_from_id, currency_to_id, account_from_id, account_to_id," +
            " currency_sell, currency_buy, date) VALUES (?,?,?,?,?,?,?);";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql.toString(), new String[] {"id"});
                ps.setLong(1, operation.getCurrencyFromId());
                ps.setLong(2, operation.getCurrencyToId());
                ps.setLong(3, operation.getCurrencyFromId());
                ps.setLong(4, operation.getAccountToId());
                ps.setDouble(5, operation.getCurrencySell());
                ps.setDouble(6, operation.getCurrencyBuy());
                ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
                return ps;
            }
        }, holder);

        return  holder.getKey().longValue();

    }

    @Override
    public void update(Operation operation) {
        String sql = "UPDATE operation SET (currency_from_id, currency_to_id, account_from_id, account_to_id," +
                " currency_sell, currency_buy, date) = (?,?,?,?,?,?,?) WHERE id=?;";
        jdbcTemplate.update(sql, operation.getCurrencyFromId(), operation.getCurrencyToId(), operation.getAccountFromId(),
                operation.getAccountToId(), operation.getCurrencySell(), operation.getCurrencyBuy(), operation.getDate(),
                operation.getId());
    }

    @Override
    public int delete(Long operationId) {
        String sql = "DELETE FROM operation WHERE id = ?";
        return jdbcTemplate.update(sql, operationId);
    }

    @Override
    public int deleteByAccountId(Long accountId) {

        String sql = "DELETE FROM operation WHERE account_from_id = ? OR account_to_id = ?";
        return jdbcTemplate.update(sql, accountId, accountId);

    }

    @Override
    public int deleteByCurrencyId(Long currencyId) {
        String sql = "DELETE FROM operation WHERE currency_from_id = ? OR currency_to_id = ?";
        return jdbcTemplate.update(sql, currencyId, currencyId);
    }
}
