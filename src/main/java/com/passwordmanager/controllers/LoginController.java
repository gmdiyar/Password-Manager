package com.passwordmanager.controllers;

import com.passwordmanager.dao.LoginDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import static com.passwordmanager.dao.LoginDAO.userID;

public class LoginController {

        @FXML
        private  TextField usernameForm;

        @FXML
        private  PasswordField passwordForm;

    @FXML
    public void login(ActionEvent event){
        String username = usernameForm.getText();
        String password = passwordForm.getText();

        LoginDAO.queryUsers(username, password);
        if (userID > 0){
            SceneController SceneController = new SceneController();
            SceneController.switchToDashboard(event);
        } else {
            System.out.println("Not a user.");
        }
    }
    public void signUp(ActionEvent event){
        SceneController SceneController = new SceneController();
        SceneController.switchToSignUp(event);
    }

}