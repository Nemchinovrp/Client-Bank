package com.becomejavasenior.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Roman on 19.01.2016.
 */
public class ConnectionProvider {
    static final String URL = "jdbc:mysql://mysql37.hostland.ru/host1378713";
    static final String USER = "host1378713_root";
    static final String PASSWORD = "265f61ab";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected database successfully...");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
