package com.becomejavasenior.dao;

import com.becomejavasenior.model.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Roman on 18.01.2016.
 */
public interface TransactionDAO {
    Transaction createTransaction(Transaction transaction);
    List<Transaction> getAllTransaction();
    Transaction getTransactionById(int id) ;
    boolean updateTransaction(Transaction transaction);
    void deleteTransaction(int id);
}
