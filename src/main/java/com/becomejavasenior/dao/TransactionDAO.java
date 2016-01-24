package com.becomejavasenior.dao;

import com.becomejavasenior.model.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Roman on 18.01.2016.
 */
public interface TransactionDAO {
    Transaction createTransaction(Transaction transaction) throws SQLException;
    List<Transaction> getAllTransaction() throws SQLException;
    Transaction getTransactionById(int id) throws SQLException;
    boolean updateTransaction(Transaction transaction) throws SQLException;
    boolean deleteTransaction(Transaction transaction) throws SQLException;
}
