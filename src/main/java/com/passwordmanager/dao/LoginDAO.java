package com.passwordmanager.dao;

import java.sql.*;

public class LoginDAO {

    static String jdbcURL = "jdbc:sqlite:/C:\\Users\\Welcome\\Desktop\\repos\\Java\\PasswordManager\\src\\main\\java\\resources\\database\\USERS.db";
    static Connection connection;

    public static int userID;

    public static void queryUsers(String inputUsername, String inputPassword){
        {
            try {
                connection = DriverManager.getConnection(jdbcURL);
                String selectAll = "SELECT * FROM users";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(selectAll);

                while (result.next()){
                    int UserID = result.getInt("user_id");
                    String username = result.getString("username");
                    String password_hash = result.getString("password_hash");
                    String email = result.getString("email");

                    if (username.equals(inputUsername) && password_hash.equals(inputPassword)){
                        userID = UserID;
                    }

                }

            } catch (SQLException e) {
                System.out.println("Error connecting to database");
                throw new RuntimeException(e);
            }
    }
    }
}
