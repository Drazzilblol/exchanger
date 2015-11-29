package com.epam.training.pas.mapper;

import com.epam.training.pas.models.Operation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Drazz on 23.11.2015.
 */
public class OperationMapper implements RowMapper<Operation> {
    @Override
    public Operation mapRow(ResultSet rs, int i) throws SQLException {
        Operation operation = new Operation();
        operation.setId(rs.getLong("id"));
        operation.setAccountFromId(rs.getLong("account_from_id"));
        operation.setAccountToId(rs.getLong("account_to_id"));
        operation.setCurrencyBuy(rs.getDouble("currency_buy"));
        operation.setCurrencySell(rs.getDouble("currency_sell"));
        operation.setCurrencyFromId(rs.getLong("currency_from_id"));
        operation.setCurrencyToId(rs.getLong("currency_to_id"));
        operation.setDate(rs.getTimestamp("date"));
        return operation;
    }
}
