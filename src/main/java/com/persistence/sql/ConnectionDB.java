package com.persistence.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public Connection getConnection() {
        Connection connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/messageApp", "root", "Tech1234");

            return connection;

        }catch (SQLException e){
            System.out.println(e.getClass().getSimpleName() + "_" + e.getMessage());
            return null;
        }
    }
}
