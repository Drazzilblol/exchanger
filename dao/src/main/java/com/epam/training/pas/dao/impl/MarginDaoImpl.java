package com.epam.training.pas.dao.impl;

import com.epam.training.pas.dao.MarginDao;
import com.epam.training.pas.mapper.MarginMapper;
import com.epam.training.pas.models.Margin;
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
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Drazz on 30.11.2015.
 */
@Repository
public class MarginDaoImpl implements MarginDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Margin> geMargins() {
        String sql = "select * from margin";
        List<Margin> margins = jdbcTemplate.query(sql, new MarginMapper());
        return margins;
    }

    @Override
    public Margin getMarginById(Long id) {
        String sql = "SELECT * FROM margin WHERE id = ?";
        Margin margin = jdbcTemplate.queryForObject(sql, new Object[]{id}, new MarginMapper());
        return margin;
    }

    @Override
    public List<Margin> getMarginsByCurrencyId(Long currencyId) {
        String sql = "select * from margin WHERE currency_id = ?";
        List<Margin> margins = jdbcTemplate.query(sql,new Object[]{currencyId}, new MarginMapper());
        return margins;
    }

    @Override
    public Long save(Margin margin) {
        String sql = "INSERT INTO margin (currency_id, creation_date, value) VALUES (?,?,?);";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql.toString(), new String[] {"id"});
                ps.setLong(1, margin.getCurrencyId());
                ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
                ps.setDouble(3, margin.getValue());
                return ps;
            }
        }, holder);

        return  holder.getKey().longValue();
    }

    @Override
    public void update(Margin margin) {
        String sql = "UPDATE margin SET (currency_id, creation_date, value) = (?,?,?) WHERE id = ?;";
        jdbcTemplate.update(sql, margin.getCurrencyId(), margin.getCreationDate(), margin.getValue(), margin.getId());
    }

    @Override
    public int delete(Long marginId) {
        String sql = "DELETE FROM margin WHERE id = ?";
        return jdbcTemplate.update(sql, marginId);
    }
}
