package org.example.xikethuoc.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    private String jdbcURL = "jdbc:mysql://localhost:3306/test";
    private String jdbcUsername = "root";
    private String jdbcPassword = "700716";


    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new DBContext().getConnection());
    }
}
