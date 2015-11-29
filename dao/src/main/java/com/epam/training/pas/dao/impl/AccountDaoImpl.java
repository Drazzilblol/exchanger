package com.epam.training.pas.dao.impl;

import com.epam.training.pas.dao.AccountDao;
import com.epam.training.pas.mapper.AccountMapper;
import com.epam.training.pas.models.Account;
import com.epam.training.pas.models.User;
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
    public List<Account> getAccountsByUserId(Long userId) {
        String sql = "SELECT id, value, name, currency_id, user_id FROM account WHERE user_id = ?";
        List<Account> accounts = jdbcTemplate.query(sql, new Object[]{userId}, new AccountMapper());
        return accounts;
    }

    @Override
    public Account getAccountById(Long id) {
        String sql = "SELECT id, value, name, currency_id, user_id FROM account WHERE id = ?";
        Account account = jdbcTemplate.queryForObject(sql, new Object[]{id}, new AccountMapper());
        return account;
    }

    @Override
    public void update(Account account) {
        String sql = "UPDATE account SET (value, name, currency_id, user_id) = (?,?,?,?) WHERE id = ?;";
        jdbcTemplate.update(sql, account.getValue(), account.getName(), account.getCurrencyId(), account.getUserId(), account.getId());
    }

    @Override
    public Long save(Account account) {
        String sql = "INSERT INTO account (value, name, currency_id, user_id) VALUES (?,?,?,?);";
       // jdbcTemplate.update(sql, account.getValue(), account.getName(), account.getCurrencyId(), account.getUserId(), account.getId());
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
                ps.setDouble(1, account.getValue());
                ps.setString(2, account.getName());
                ps.setLong(3, account.getCurrencyId());
                ps.setLong(4, account.getUserId());
                return ps;
            }
        }, holder);

        return  holder.getKey().longValue();
    }


    @Override
    public int delete(Long accountId) {
        String sql = "DELETE FROM account CASCADE WHERE id = ?;";
        String s = "DELETE FROM some_child_table WHERE some_fk_field IN (SELECT some_id FROM some_Table);"+
       "DELETE FROM some_table;";
        return jdbcTemplate.update(sql, accountId);


    }

    @Override
    public Account getBankAccount(Long currencyId) {
        String sql = "SELECT id, value, name, currency_id, user_id FROM account WHERE user_id = 1 and currency_id = ?";
        Account account = jdbcTemplate.queryForObject(sql, new Object[]{currencyId}, new AccountMapper());
        return account;
    }
}
