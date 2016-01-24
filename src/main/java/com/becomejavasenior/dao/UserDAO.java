package com.becomejavasenior.dao;

import com.becomejavasenior.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Roman on 18.01.2016.
 */
public interface UserDAO {
    User createUser(User user) throws SQLException;
    List<User> getAllUser() throws SQLException;
    User getUserById(int id) throws SQLException;
    boolean updateUser(User user) throws SQLException;
    boolean deleteUser(User user) throws SQLException;
}
