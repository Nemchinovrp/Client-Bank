package com.becomejavasenior.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Roman on 19.01.2016.
 */
public class ConnectionProvider {
    static final Logger loggerConn = LogManager.getRootLogger();

    private InitialContext ic;
    private DataSource ds;

    public Connection getConnection() throws SQLException {
        try {
            ic = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        try {
            loggerConn.info("Create datasource");
            ds = (DataSource) ic.lookup("java:/comp/env/jdbc/host1378713");
            loggerConn.info("Connection to database");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return ds.getConnection();
    }
}
