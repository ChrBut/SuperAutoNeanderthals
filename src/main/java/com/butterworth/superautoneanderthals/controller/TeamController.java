package com.butterworth.superautoneanderthals.controller;

import com.butterworth.superautoneanderthals.model.*;
import com.butterworth.superautoneanderthals.repository.TeamRepository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TeamController {

    private int pos1Counter = 0;
    private int pos2Counter = 0;
    private int pos3Counter = 0;
    private int pos4Counter = 0;
    private int pos5Counter = 0;

    private Image club = new Image(getClass().getResource("/images/PlaceholderClub.jpg").toExternalForm());
    private Image giantClub = new Image(getClass().getResource("/images/PlacehloderGiantClub.jpg").toExternalForm());
    private Image sling = new Image(getClass().getResource("/images/PlaceholderSling.jpg").toExternalForm());
    private Image spear = new Image(getClass().getResource("/images/PlaceholderSpear.jpg").toExternalForm());

    @FXML
    private TextField name;
    @FXML
    private ImageView position1;
    @FXML
    private ImageView position2;
    @FXML
    private ImageView position3;
    @FXML
    private ImageView position4;
    @FXML
    private ImageView position5;

    @FXML
    protected void changePosition1Click(){
        pos1Counter++;
        if(pos1Counter > 3){
            pos1Counter = 0;
        }
        switch (pos1Counter){
            case 0:
                position1.setImage(club);
                break;
            case 1:
                position1.setImage(giantClub);
                break;
            case 2:
                position1.setImage(sling);
                break;
            case 3:
                position1.setImage(spear);
                break;
            default:
                position1.setImage(null);
                break;
        }
    }

    @FXML
    protected void changePosition2Click(){
        pos2Counter++;
        if(pos2Counter > 3){
            pos2Counter = 0;
        }
        switch (pos2Counter){
            case 0:
                position2.setImage(club);
                break;
            case 1:
                position2.setImage(giantClub);
                break;
            case 2:
                position2.setImage(sling);
                break;
            case 3:
                position2.setImage(spear);
                break;
            default:
                position2.setImage(null);
                break;
        }
    }

    @FXML
    protected void changePosition3Click(){
        pos3Counter++;
        if(pos3Counter > 3){
            pos3Counter = 0;
        }
        switch (pos3Counter){
            case 0:
                position3.setImage(club);
                break;
            case 1:
                position3.setImage(giantClub);
                break;
            case 2:
                position3.setImage(sling);
                break;
            case 3:
                position3.setImage(spear);
                break;
            default:
                position3.setImage(null);
                break;
        }
    }

    @FXML
    protected void changePosition4Click(){
        pos4Counter++;
        if(pos4Counter > 3){
            pos4Counter = 0;
        }
        switch (pos4Counter){
            case 0:
                position4.setImage(club);
                break;
            case 1:
                position4.setImage(giantClub);
                break;
            case 2:
                position4.setImage(sling);
                break;
            case 3:
                position4.setImage(spear);
                break;
            default:
                position4.setImage(null);
                break;
        }
    }

    @FXML
    protected void changePosition5Click(){
        pos5Counter++;
        if(pos5Counter > 3){
            pos5Counter = 0;
        }
        switch (pos5Counter){
            case 0:
                position5.setImage(club);
                break;
            case 1:
                position5.setImage(giantClub);
                break;
            case 2:
                position5.setImage(sling);
                break;
            case 3:
                position5.setImage(spear);
                break;
            default:
                position5.setImage(null);
                break;
        }
    }

    @FXML
    protected void submitClick(){
        if(name.getText().isBlank()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid name");
            alert.setHeaderText("Name may not be blank");
            alert.setContentText("Enter a valid and proper name");

            alert.showAndWait();
        }else{
            //create timestamp to be the core of the ids
            long timestamp = Long.parseLong(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
            Team team = new Team(name.getText());
            team.addTeamMember(pickNeanderthalByPositionCounter(pos1Counter, timestamp + 1));
            team.addTeamMember(pickNeanderthalByPositionCounter(pos2Counter, timestamp + 2));
            team.addTeamMember(pickNeanderthalByPositionCounter(pos3Counter, timestamp + 3));
            team.addTeamMember(pickNeanderthalByPositionCounter(pos4Counter, timestamp + 4));
            team.addTeamMember(pickNeanderthalByPositionCounter(pos5Counter, timestamp + 5));

            TeamRepository teamRepository = TeamRepository.getInstance();
            teamRepository.getTeamList().add(team);

            goToMainMenu();
        }
    }

    private Neanderthal pickNeanderthalByPositionCounter(int posCounter, long id){
        Neanderthal neanderthal;

        switch(posCounter){
            case 0:
                neanderthal = new ClubSwinger(id);
                break;
            case 1:
                neanderthal = new GiantClubSwinger(id);
                break;
            case 2:
                neanderthal = new SlingShooter(id);
                break;
            case 3:
                neanderthal = new SpearThrower(id);
                break;
            default:
                neanderthal = null;
                break;
        }
        return neanderthal;
    }

    private void goToMainMenu(){
        try {
            Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/butterworth/superautoneanderthals/main-menu.fxml")));
            Stage stage = (Stage) name.getScene().getWindow();
            Scene scene = new Scene(root, 400, 400);
            stage.setScene(scene);
            stage.setTitle("Main Menu");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
