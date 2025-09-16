package com.passwordmanager.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.passwordmanager.dao.LoginDAO.userID;

public class PasswordsDAO {

    static String jdbcURL = "jdbc:sqlite:/C:\\Users\\Welcome\\Desktop\\repos\\Java\\PasswordManager\\src\\main\\java\\resources\\database\\USERS.db";
    static Connection connection;

    public List<String> getPlatforms() throws SQLException {

        List<String> platforms = new ArrayList<>();

        connection = DriverManager.getConnection(jdbcURL);
        String selectPlatforms = "SELECT platform FROM passwords WHERE master_user =" + userID;
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(selectPlatforms);

        while (result.next()) {
            platforms.add(result.getString("platform"));
        } return platforms;
    }

    public List<String> getPasswords() throws SQLException {

        List<String> passwords = new ArrayList<>();

        connection = DriverManager.getConnection(jdbcURL);
        String selectPlatforms = "SELECT password FROM passwords WHERE master_user =" + userID;
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(selectPlatforms);

        while (result.next()) {
            passwords.add(result.getString("password"));
        } return passwords;
    }
}