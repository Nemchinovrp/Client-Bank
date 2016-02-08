package com.becomejavasenior.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Roman on 19.01.2016.
 */
public class ConnectionProvider {
    private InitialContext ic;
    private DataSource ds;

    public Connection getConnection() throws SQLException {
        try {
            ic = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        try {
            ds = (DataSource) ic.lookup("java:/comp/env/jdbc/TestDB");
            System.out.println("Connect to database");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return ds.getConnection();
    }
}
