package com.epam.training.pas.dao.impl;

import com.epam.training.pas.dao.AccountDao;
import com.epam.training.pas.models.Account;
import com.epam.training.pas.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
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
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
        List<Account> accounts = new ArrayList<>();
        while (rs.next()) {
            accounts.add(new Account(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getDouble(5)
            ));
        }

        return accounts;
    }

    @Override
    public List<Account> getAccountsByUser(User user) {
        String sql = "SELECT id, value, name, currency_id, user_id FROM account WHERE user_id = " + user.getId();
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
        List<Account> accounts = new ArrayList<>();
        while (rs.next()) {
            accounts.add(new Account(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getDouble(5)
            ));
        }

        return accounts;
    }

    @Override
    public Account getAccountById(int id) {
        String sql = "SELECT id, value, name, currency_id, user_id FROM account WHERE id = " + id;
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
        Account account = null;
        if (rs.next()) {
            account = new Account(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getDouble(5)
            );
        }
        return account;
    }

    @Override
    public void save(Account account) {
        String sql = "INSERT INTO account (value, name, currency_id, user_id) " +
            "VALUES ('" + account.getValue() + "', " +
            "'" + account.getName() + "', " +
            "'" + account.getCurrencyId() + "', " +
            "'" + account.getUserId() + "');";
        jdbcTemplate.update(sql);

    }

    @Override
    public void delete(Account account) {
        String sql = "DELETE FROM account WHERE id = " + account.getId() + ";";
        jdbcTemplate.update(sql);
    }

    @Override
    public void delete(int accountId) {
        String sql = "DELETE FROM account WHERE id = " + accountId + ";";
        jdbcTemplate.update(sql);

    }
}
