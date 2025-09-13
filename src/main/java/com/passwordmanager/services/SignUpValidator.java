package com.passwordmanager.services;

import java.util.Objects;

public class SignUpValidator {

    char[] disallowedChars = {'!', '@', '#', '$', '%', '^', '&', '*',
            '(', ')', '-', '=', '+', '<', '>', ':',
            ' '};

    public boolean checkUsername(String username) {
        Objects.requireNonNull(username, "Username cannot be empty");
        boolean usernameAllowed = true;
        if (username.isBlank()) {
            usernameAllowed = false;
            System.out.println("Username cannot be empty");
        }
        for (char c : username.toCharArray()) {
            for (char bad : disallowedChars) {
                if (c == bad) {
                    usernameAllowed = false;
                    break;
                }
            }
        }
        return usernameAllowed;
    }

    public boolean checkPassword(String password) {
        if (password.isBlank()) {
            System.out.println("Password cannot be empty");
            return false;
        }
        return true;
    }

    public boolean checkEmail(String email) {
        if (!email.isBlank() && email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            return true;
        } else {
            System.out.println("email cannot be empty");
            return false;
        }
    }
}
