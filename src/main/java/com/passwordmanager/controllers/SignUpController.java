package com.passwordmanager.controllers;

import com.passwordmanager.dao.SignUpDAO;
import com.passwordmanager.services.SignUpValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class SignUpController {
        @FXML
        private TextField usernameForm;

        @FXML
        private PasswordField passwordForm;

        @FXML
        private TextField emailForm;

    @FXML
    public void signUp(ActionEvent event){

        String username = usernameForm.getText();
        String password = passwordForm.getText();
        String email = emailForm.getText();

        SignUpValidator SignUpValidator = new SignUpValidator();

        boolean legalUsername = SignUpValidator.checkUsername(username);
        boolean legalPassword = SignUpValidator.checkPassword(password);
        boolean legalEmail = SignUpValidator.checkEmail(email);

        if (legalUsername & legalPassword & legalEmail){
            SignUpDAO.signUp(username, password, email);
        } else if (legalUsername & legalPassword & !legalEmail){
            System.out.println("invalid email");
        } else if (legalUsername & legalEmail & !legalPassword){
            System.out.println("invalid password");
        } else if (legalPassword & legalEmail & !legalUsername){
            System.out.println("Invalid username");
        }

    }
    @FXML
    public void backToLogin(ActionEvent event){
        SceneController SceneController = new SceneController();
        SceneController.switchToLogin(event);
    }
}
