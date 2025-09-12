package com.passwordmanager.controllers;

import javafx.event.ActionEvent;

import static com.passwordmanager.dao.LoginDAO.loggedIn;

public class DashboardController {

    public void logout(ActionEvent event){
        loggedIn = false;

        SceneController SceneController = new SceneController();
        SceneController.switchToLogin(event);
    }

}
