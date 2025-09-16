package com.passwordmanager.controllers;

import com.passwordmanager.dao.AddEntryDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

import static com.passwordmanager.dao.LoginDAO.userID;

public class DashboardController {

    DashboardController(){
        //
    }

    @FXML
    private TextField platformEntry;

    @FXML
    private PasswordField passwordEntry1;

    @FXML
    private PasswordField passwordEntry2;

    @FXML
    public void newEntry(ActionEvent event) throws SQLException {
        int ID = userID;
        String platform = platformEntry.getText();
        String password1 = passwordEntry1.getText();
        String password2 = passwordEntry2.getText();

        if (password1.equals(password2)){
            AddEntryDAO.addNewEntry(ID, platform, password1);
        } else {
            System.out.println("Passwords must match.");
        }

    }


    public void logout(ActionEvent event){
        userID = 0;

        SceneController SceneController = new SceneController();
        SceneController.switchToLogin(event);
    }

}
