package com.becomejavasenior.dao.impl;

import java.sql.*;

/**
 * Created by Roman on 20.01.2016.
 */
public class JDBCUtil {
    public static void close(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null && !rs.isClosed()) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (st != null && !st.isClosed()) {
                try {
                    st.close();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null && !conn.isClosed()) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(ResultSet rs, PreparedStatement pt, Connection conn)  {
        try {
            if (rs != null && !rs.isClosed()) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pt != null && !pt.isClosed()) {
                try {
                    pt.close();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null && !conn.isClosed()) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(PreparedStatement pt, Connection conn)  {
        try {
            if (pt != null && !pt.isClosed()) {
                try {
                    pt.close();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null && !conn.isClosed()) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}