package com.cursmysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DbConnector {
    private static Connection connection = null;

    public static Connection getDbConnection() {
        String url = "jdbc:mysql://localhost:3306/facultate";
        String pass = "";
        String user = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println(connection);
            System.out.println("Succesfully connected to database");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {

        }
        return connection;
    }
}
