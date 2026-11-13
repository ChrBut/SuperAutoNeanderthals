package com.butterworth.superautoneanderthals.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainController {
    @FXML
    private ComboBox selectedTeam1;

    @FXML
    private ComboBox selectedTeam2;

    @FXML
    protected void teamMenuClick() {
        try {
            Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/butterworth/superautoneanderthals/team-menu.fxml")));
            Stage stage = (Stage) selectedTeam1.getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setTitle("Team Menu");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
