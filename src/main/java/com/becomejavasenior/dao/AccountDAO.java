package com.becomejavasenior.dao;

import com.becomejavasenior.model.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Roman on 18.01.2016.
 */
public interface AccountDAO {
    Account createAccount(Account transaction);
    List<Account> getAllAccount();
    Account getAccountById(int id);
    boolean updateAccount(Account account);
    void deleteAccount(int id);
}
