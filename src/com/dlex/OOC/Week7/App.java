package com.dlex.OOC.Week7;

import java.sql.*;

public class App {

    private Connection connect() {
        Connection conn = null;
        String SQL_SELECT = "SELECT\t* FROM\t\"tbl_Link\";";
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to the PostgreSQL server successfully.");
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.connect().toString());
    }
}
