package com.passwordmanager.controllers;

import com.passwordmanager.dao.AddEntryDAO;
import com.passwordmanager.dao.PasswordsDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.List;

import static com.passwordmanager.dao.LoginDAO.userID;

public class DashboardController {

    public static class PasswordEntry{

        private final String platform;
        private final String password;
        public PasswordEntry(String platform, String password) {
            this.platform = platform;
            this.password = password;
        }
        public String getPlatform() { return platform; }
        public String getPassword() { return password; }
    }

    @FXML
    private TableView<PasswordEntry> mainTable;

    @FXML
    private TableColumn<PasswordEntry, String> platformColumn;

    @FXML
    private TableColumn<PasswordEntry, String> passwordsColumn;

    public void populateTable() throws SQLException {
        PasswordsDAO passwordsDAO = new PasswordsDAO();

        List<String> platforms = passwordsDAO.getPlatforms();
        List<String> passwords = passwordsDAO.getPasswords();

        ObservableList<PasswordEntry> entries = FXCollections.observableArrayList();

        for (int i = 0; i < platforms.size() && i < passwords.size(); i++){
            entries.add(new PasswordEntry(platforms.get(i), passwords.get(i)));
        }

        platformColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlatform()));
        passwordsColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPassword()));

        mainTable.setItems(entries);
    }

    @FXML
    public void initialize(){
        try{
            populateTable();
        } catch (SQLException e){
            e.printStackTrace();
        }
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
            populateTable();
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


