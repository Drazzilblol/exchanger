package com.epam.training.pas.mapper;

import com.epam.training.pas.models.Margin;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Drazz on 30.11.2015.
 */
public class MarginMapper implements RowMapper<Margin> {
    @Override
    public Margin mapRow(ResultSet resultSet, int i) throws SQLException {
        Margin margin = new Margin();
        margin.setId(resultSet.getLong("id"));
        margin.setCurrencyId(resultSet.getLong("currency_id"));
        margin.setValue(resultSet.getDouble("value"));
        return margin;
    }
}
