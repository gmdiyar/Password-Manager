package com.passwordmanager.services;

public class SignUpValidator {

    public boolean passwordAllowed = true;
    public boolean usernameAllowed = true;
    public boolean emailAllowed = true;

    char[] disallowedChars = {'!', '@', '#', '$','%', '^', '&', '*',
                                '(', ')', '-', '=', '+', '<', '>', ':',
                                ' '};

    public boolean checkUsername(String username){

        for (char c : username.toCharArray()){
            for (char bad : disallowedChars){
                if (c == bad){
                    usernameAllowed = false;
                    break;
                }
            }
        }
        return usernameAllowed;
    }

    public boolean checkPassword(String password){
        for (char c : password.toCharArray()){
            for (char bad : disallowedChars){
                if (c == bad){
                    usernameAllowed = false;
                    break;
                }
            }
        }
        return passwordAllowed;
    }

    public boolean checkEmail(String email){
        if (email == null || !email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")){
            emailAllowed = false;
        }
        return emailAllowed;
    }
}
