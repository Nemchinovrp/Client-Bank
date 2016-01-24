package com.becomejavasenior.dao;

import com.becomejavasenior.model.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Roman on 18.01.2016.
 */
public interface AccountDAO {
    Account createAccount(Account transaction) throws SQLException;
    List<Account> getAllAccount() throws SQLException;
    Account getAccountById(int id) throws SQLException;
    boolean updateAccount(Account account) throws SQLException;
    boolean deleteAccount(Account account) throws SQLException;
}
