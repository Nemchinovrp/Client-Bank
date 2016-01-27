package com.becomejavasenior.dao;

import com.becomejavasenior.model.Currency;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Roman on 18.01.2016.
 */
public interface CurrencyDAO {
    Currency createCurrency(Currency currency) throws SQLException;
    List<Currency> getAllCurrency() throws SQLException;
    Currency getCurrencyById(int id) throws SQLException;
    boolean updateCurrency(Currency currency) throws SQLException;
    void deleteCurrency(int id) throws SQLException;
}
