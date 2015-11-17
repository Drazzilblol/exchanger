package com.epam.training.pas.dao.impl;

import com.epam.training.pas.dao.UserDao;
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
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUserById(int id) {
        String sql = "SELECT id, username, password FROM users WHERE id = " + id;
        String q = "select id, username, password from customers";
       // System.out.println(jdbcTemplate.queryForList(q).size());
        User c = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            return new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
        });
        return c;

      /*  Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            Customer customer = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                customer = new Customer(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password")
                );
            }
            rs.close();
            ps.close();
            return customer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }*/

    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
