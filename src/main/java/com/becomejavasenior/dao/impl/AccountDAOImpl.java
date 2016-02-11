package com.becomejavasenior.dao.impl;

import com.becomejavasenior.dao.AccountDAO;
import com.becomejavasenior.dao.ConnectionProvider;
import com.becomejavasenior.model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman on 19.01.2016.
 */
public class AccountDAOImpl implements AccountDAO {
    private static final String QUERY_INSERT = "INSERT INTO Account(id, account, id_currency, balance, users_id) VALUES (?,?,?,?,?)";
    private static final String QUERY_SELECT_ALL = "SELECT * FROM Account";
    private static final String QUERY_SELECT_ID = "SELECT * FROM  Account WHERE id = ?";
    private static final String QUERY_UPDATE = "UPDATE Account SET account = ?, id_currency = ?, balance = ?, user_id = ? WHERE id = ?";
    private static final String QUERY_DELETE = "DELETE FROM Account WHERE id = ?";
    Connection connection;

    public AccountDAOImpl() {
        ConnectionProvider cp = new ConnectionProvider();
        try {
            connection = cp.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account createAccount(Account account) {
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(QUERY_INSERT);
            ps.setInt(1, account.getId());
            ps.setString(2, account.getAccountType());
            ps.setInt(3, account.getIdCurrency());
            ps.setDouble(4, account.getBalance());
            ps.setInt(5, account.getUsersId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(ps, connection);
        }
        return account;
    }

    @Override
    public List<Account> getAllAccount() {
        List<Account> accountList = new ArrayList<Account>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(QUERY_SELECT_ALL);
            Account account = null;
            while (rs.next()) {
                account = new Account();
                account.setId(rs.getInt(1));
                account.setAccountType(rs.getString(2));
                account.setIdCurrency(rs.getInt(3));
                account.setBalance(rs.getDouble(4));
                account.setUsersId(rs.getInt(5));
                accountList.add(account);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(rs, st, connection);
        }

        return accountList;
    }

    @Override
    public Account getAccountById(int id) {
        Account account = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(QUERY_SELECT_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                account = new Account();
                account.setId(rs.getInt(1));
                account.setAccountType(rs.getString(2));
                account.setIdCurrency(rs.getInt(3));
                account.setBalance(rs.getDouble(4));
                account.setUsersId(rs.getInt(5));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(rs, ps, connection);
        }
        return account;
    }

    @Override
    public boolean updateAccount(Account account) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(QUERY_UPDATE);
            ps.setString(1, account.getAccountType());
            ps.setInt(2, account.getIdCurrency());
            ps.setDouble(3, account.getBalance());
            ps.setInt(4, account.getUsersId());
            ps.setInt(5, account.getId());
            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(ps, connection);
        }
        return false;
    }

    @Override
    public void deleteAccount(int id) {
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
