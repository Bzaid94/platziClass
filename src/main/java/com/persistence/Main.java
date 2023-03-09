package com.persistence;

import com.persistence.sql.ConnectionDB;

public class Main {
    public static void main(String[] args) {
        ConnectionDB connectionDB = new ConnectionDB();
        connectionDB.getConnection();
    }
}