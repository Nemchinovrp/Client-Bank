package com.becomejavasenior.dao.impl;

import com.becomejavasenior.dao.ConnectionProvider;
import com.becomejavasenior.dao.CurrencyDAO;
import com.becomejavasenior.model.Currency;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman on 19.01.2016.
 */
public class CurrencyDAOImpl implements CurrencyDAO {
    private static final String QUERY_INSERT = "INSERT INTO Currency(id, name, rate) VALUES (?,?,?)";
    private static final String QUERY_SELECT_ALL = "SELECT * FROM Currency";
    private static final String QUERY_SELECT_ID = "SELECT * FROM  Currency WHERE id = ?";
    private static final String QUERY_UPDATE = "UPDATE Currency SET name = ?, rate = ? WHERE id = ?";
    private static final String QUERY_DELETE = "DELETE FROM Currency WHERE id = ?";
    Connection connection;

    public CurrencyDAOImpl() {
        ConnectionProvider cp = new ConnectionProvider();
        try {
            connection = cp.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
      public Currency createCurrency(Currency currency) {
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(QUERY_INSERT);
            ps.setInt(1, currency.getId());
            ps.setString(2, currency.getName());
            ps.setDouble(3, currency.getRate());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(ps, connection);
        }
        return currency;
    }

    @Override
    public List<Currency> getAllCurrency()  {
        List<Currency> currencies = new ArrayList<Currency>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(QUERY_SELECT_ALL);
            Currency currency = null;
            while (rs.next()) {
                currency = new Currency();
                currency.setId(rs.getInt("id"));
                currency.setName(rs.getString("name"));
                currency.setRate(rs.getDouble("rate"));
                currencies.add(currency);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(rs, st, connection);
        }

        return currencies;
    }

    @Override
    public Currency getCurrencyById(int id) {
        Currency currency = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(QUERY_SELECT_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                currency = new Currency();
                currency.setId(rs.getInt(1));
                currency.setName(rs.getString(2));
                currency.setRate(rs.getDouble(3));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
           JDBCUtil.close(rs, ps, connection);
        }
        return currency;
    }

    @Override
    public boolean updateCurrency(Currency currency)  {
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement(QUERY_UPDATE);
            ps.setString(1, currency.getName());
            ps.setDouble(2, currency.getRate());
            ps.setInt(3, currency.getId());
            return ps.executeUpdate() == 1;

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            JDBCUtil.close(ps, connection);
        }
        return false;
    }

    @Override
    public void deleteCurrency(int id)  {
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement(QUERY_DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            JDBCUtil.close(ps, connection);
        }

    }
}
