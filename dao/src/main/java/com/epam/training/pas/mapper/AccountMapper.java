package com.epam.training.pas.mapper;

import com.epam.training.pas.models.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Drazz on 23.11.2015.
 */
public class AccountMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int i) throws SQLException {
        Account account = new Account();
        account.setId(rs.getLong("id"));
        account.setName(rs.getString("name"));
        account.setUserId(rs.getLong("user_id"));
        account.setCurrencyId(rs.getLong("currency_id"));
        account.setValue(rs.getDouble("value"));
        return account;
    }
}
