package com.passwordmanager.dao;

import java.sql.*;

public class AddEntryDAO {

    static String jdbcURL = "jdbc:sqlite:/C:\\Users\\Welcome\\Desktop\\repos\\Java\\PasswordManager\\src\\main\\java\\resources\\database\\USERS.db";
    static Connection connection;

    public static void addNewEntry(int userID, String platform, String password) throws SQLException {

        connection = DriverManager.getConnection(jdbcURL);
        String insertPassword = "INSERT INTO passwords (master_user, platform, password) VALUES (?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(insertPassword);

        preparedStatement.setInt(1,userID);
        preparedStatement.setString(2, platform);
        preparedStatement.setString(3, password);

        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0){
            System.out.println("Password successfully added");
        } else {
            System.out.println("Error adding new password");
        }

        preparedStatement.close();
        connection.close();

    }

}
