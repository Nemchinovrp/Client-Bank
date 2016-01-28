package com.becomejavasenior.dao;

import com.becomejavasenior.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Roman on 18.01.2016.
 */
public interface UserDAO {
    User createUser(User user);

    List<User> getAllUser();

    User getUserById(int id);

    boolean updateUser(User user);

    void deleteUser(int id);
}
