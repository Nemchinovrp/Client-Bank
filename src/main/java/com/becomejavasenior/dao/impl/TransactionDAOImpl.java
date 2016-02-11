package com.becomejavasenior.dao.impl;

import com.becomejavasenior.dao.ConnectionProvider;
import com.becomejavasenior.dao.TransactionDAO;
import com.becomejavasenior.model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman on 19.01.2016.
 */
public class TransactionDAOImpl implements TransactionDAO {
    private static final String QUERY_INSERT = "INSERT INTO Transaction(id, id_account, operation, amount) VALUES (?,?,?,?)";
    private static final String QUERY_SELECT_ALL = "SELECT * FROM Transaction";
    private static final String QUERY_SELECT_ID = "SELECT * FROM  Transaction WHERE id = ?";
    private static final String QUERY_UPDATE = "UPDATE Transaction SET id_account = ?, operation = ?, amount = ? WHERE id = ?";
    private static final String QUERY_DELETE = "DELETE FROM Transaction WHERE id = ?";
    Connection connection;

    public TransactionDAOImpl() {
        ConnectionProvider cp = new ConnectionProvider();
        try {
            connection = cp.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Transaction createTransaction(Transaction transaction){
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(QUERY_INSERT);
            ps.setInt(1, transaction.getId());
            ps.setInt(2, transaction.getIdAccount());
            ps.setString(3, transaction.getOperation());
            ps.setDouble(4, transaction.getAmount());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(ps, connection);
        }
        return transaction;
    }

    @Override
    public List<Transaction> getAllTransaction()  {
        List<Transaction> transactionList = new ArrayList<Transaction>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(QUERY_SELECT_ALL);
            Transaction transaction = null;
            while (rs.next()) {
                transaction = new Transaction();
                transaction.setId(rs.getInt(1));
                transaction.setIdAccount(rs.getInt(2));
                transaction.setOperation(rs.getString(3));
                transaction.setAmount(rs.getDouble(4));
                transactionList.add(transaction);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(rs, st, connection);
        }

        return transactionList;
    }

    @Override
    public Transaction getTransactionById(int id)  {
        Transaction transaction = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(QUERY_SELECT_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                transaction = new Transaction();
                transaction.setId(rs.getInt(1));
                transaction.setIdAccount(rs.getInt(2));
                transaction.setOperation(rs.getString(3));
                transaction.setAmount(rs.getDouble(4));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(rs, ps, connection);
        }
        return transaction;
    }

    @Override
    public boolean updateTransaction(Transaction transaction)  {
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement(QUERY_UPDATE);
            ps.setInt(1, transaction.getIdAccount());
            ps.setString(2, transaction.getOperation());
            ps.setDouble(3, transaction.getAmount());
            ps.setInt(4, transaction.getId());
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
    public void deleteTransaction(int id)  {
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
