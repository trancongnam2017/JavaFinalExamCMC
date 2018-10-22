package com.Java.sqlserver;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
        public static Connection openConnection() {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection cnn = DriverManager.getConnection(
                        "jdbc:sqlserver://localhost:1433; instance=SQLEXPRESS;databaseName=FinalJavaEx1", "Demo1", "1");
                return cnn;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static void closeConnection(Connection cnn, PreparedStatement ps, ResultSet rs, CallableStatement cs) {
            try {
                if (cs != null && !cs.isClosed()) {
                    cs.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            try {
                if (cnn != null && !cnn.isClosed()) {
                    cnn.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
