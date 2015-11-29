package com.epam.training.pas.dao.impl;

import com.epam.training.pas.dao.OperationDao;
import com.epam.training.pas.mapper.OperationMapper;
import com.epam.training.pas.models.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
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
    public Operation getOperationById(int id) {
        String sql = "SELECT * FROM operation WHERE id = ?";
        Operation operation = jdbcTemplate.queryForObject(sql, new Object[]{id}, new OperationMapper());
        return operation;
    }

    @Override
    public void save(Operation operation) {
        String sql = "INSERT INTO operation (currency_from_id, currency_to_id, account_from_id, account_to_id," +
            " currency_sell, currency_buy, date) VALUES (?,?,?,?,?,?,?);";
        jdbcTemplate.update(sql, operation.getCurrencyFromId(), operation.getCurrencyToId(), operation.getAccountFromId(),
            operation.getAccountToId(), operation.getCurrencySell(), operation.getCurrencyBuy(), operation.getDate());

    }

    @Override
    public void delete(int operationId) {
        String sql = "DELETE FROM operation WHERE id = ?";
        jdbcTemplate.update(sql, operationId);

    }
}
