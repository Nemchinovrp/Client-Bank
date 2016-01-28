package com.becomejavasenior.dao;

import com.becomejavasenior.model.Currency;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Roman on 18.01.2016.
 */
public interface CurrencyDAO {
    Currency createCurrency(Currency currency);
    List<Currency> getAllCurrency();
    Currency getCurrencyById(int id);
    boolean updateCurrency(Currency currency);
    void deleteCurrency(int id);
}
