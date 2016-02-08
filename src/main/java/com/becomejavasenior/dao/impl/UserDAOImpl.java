package com.becomejavasenior.dao.impl;

import com.becomejavasenior.controllers.ConvertDate;
import com.becomejavasenior.dao.ConnectionProvider;
import com.becomejavasenior.dao.UserDAO;
import com.becomejavasenior.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman on 19.01.2016.
 */
public class UserDAOImpl implements UserDAO {
    private static final String QUERY_INSERT = "INSERT INTO User(id, first_name, last_name, email, password, dateOfBirth, registrationdate, id_gender, id_role) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String QUERY_SELECT_ALL = "SELECT * FROM User";
    private static final String QUERY_SELECT_ID = "SELECT * FROM  User WHERE id = ?";
    private static final String QUERY_UPDATE = "UPDATE User SET first_name = ?, last_name = ?, email = ?, password = ?, dateOfBirth = ?, registrationdate = ?, id_gender = ?, id_role = ? WHERE id = ?";
    private static final String QUERY_DELETE = "DELETE FROM User WHERE id = ?";
    Connection connection;

    public UserDAOImpl() {
        ConnectionProvider cp = new ConnectionProvider();
        try {
            connection = cp.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User createUser(User user) {
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(QUERY_INSERT);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());
            ps.setDate(6, ConvertDate.convert(user.getDateOfBirth()));
            ps.setDate(7, ConvertDate.convert(user.getRegistrationDate()));
            ps.setInt(8, user.getIdGender());
            ps.setInt(9, user.getIdRole());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(ps, connection);
        }
        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<User>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(QUERY_SELECT_ALL);
            User user = null;
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setDateOfBirth(rs.getDate(6));
                user.setRegistrationDate(rs.getDate(7));
                user.setIdGender(rs.getInt(8));
                user.setIdRole(rs.getInt(9));
                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(rs, st, connection);
        }

        return userList;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(QUERY_SELECT_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setDateOfBirth(rs.getDate(6));
                user.setRegistrationDate(rs.getDate(7));
                user.setIdGender(rs.getInt(8));
                user.setIdRole(rs.getInt(9));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(rs, ps, connection);
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(QUERY_UPDATE);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setDate(5, ConvertDate.convert(user.getDateOfBirth()));
            ps.setDate(6, ConvertDate.convert(user.getRegistrationDate()));
            ps.setInt(7, user.getIdGender());
            ps.setInt(8, user.getIdRole());
            ps.setInt(9, user.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(ps, connection);
        }
    }

    @Override
    public void deleteUser(int id) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(QUERY_DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(ps, connection);
        }
    }
}
