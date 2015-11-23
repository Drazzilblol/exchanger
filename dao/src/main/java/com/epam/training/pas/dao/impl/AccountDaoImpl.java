package com.epam.training.pas.dao.impl;

import com.epam.training.pas.dao.AccountDao;
import com.epam.training.pas.mapper.AccountMapper;
import com.epam.training.pas.models.Account;
import com.epam.training.pas.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Drazz on 16.11.2015.
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Account> getAccounts() {
        String sql = "SELECT id, value, name, currency_id, user_id FROM account";
        List<Account> accounts = jdbcTemplate.query(sql, new AccountMapper());
        return accounts;
    }

    @Override
    public List<Account> getAccountsByUser(User user) {
        String sql = "SELECT id, value, name, currency_id, user_id FROM account WHERE user_id = ?";
        List<Account> accounts = jdbcTemplate.query(sql, new Object[]{user.getId()}, new AccountMapper());
        return accounts;
    }

    @Override
    public Account getAccountById(int id) {
        String sql = "SELECT id, value, name, currency_id, user_id FROM account WHERE id = ?";
        Account account = jdbcTemplate.queryForObject(sql, new Object[]{id}, new AccountMapper());
        return account;
    }

    @Override
    public void save(Account account) {
        String sql = "INSERT INTO account (value, name, currency_id, user_id) VALUES( ?,?,?,?);";
        jdbcTemplate.update(sql, account.getValue(), account.getName(), account.getCurrencyId(), account.getUserId());
    }

    @Override
    public void delete(Account account) {
        String sql = "DELETE FROM account WHERE id = ?;";
        jdbcTemplate.update(sql, account.getId());
    }

    @Override
    public void delete(int accountId) {
        String sql = "DELETE FROM account WHERE id = ?;";
        jdbcTemplate.update(sql, accountId);
    }
}
