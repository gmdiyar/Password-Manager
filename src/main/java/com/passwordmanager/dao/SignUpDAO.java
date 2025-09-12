package com.passwordmanager.dao;

import java.sql.*;

public class SignUpDAO {

    static String jdbcURL = "jdbc:sqlite:/C:\\Users\\Welcome\\Desktop\\repos\\Java\\PasswordManager\\src\\main\\java\\resources\\database\\USERS.db";
    static Connection connection;


    public static void signUp(String inputUsername, String inputPassword, String inputEmail){
        {
            try {
                connection = DriverManager.getConnection(jdbcURL);
                String insertRecord = "INSERT INTO users (username, password_hash, email) VALUES (?,?,?)";

                PreparedStatement preparedStatement = connection.prepareStatement(insertRecord);
                preparedStatement.setString(1, inputUsername);

                preparedStatement.setString(1, inputUsername);
                preparedStatement.setString(2,inputPassword);
                preparedStatement.setString(3,inputEmail);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0){
                    System.out.println("User Registered Successfully.");
                } else {
                    System.out.println("Failed to Register User.");
                }

                preparedStatement.close();
                connection.close();

            } catch (SQLException e) {
                System.out.println("Error connecting to database");
                throw new RuntimeException(e);
            }
        }
    }

}
