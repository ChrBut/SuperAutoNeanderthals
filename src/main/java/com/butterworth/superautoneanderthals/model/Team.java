package com.butterworth.superautoneanderthals.model;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<Neanderthal> teamMembers;
    private boolean leftTeam;

    public Team(String name){
        this.name = name;
        this.teamMembers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isLeftTeam() {
        return leftTeam;
    }

    public List<Neanderthal> getTeamMembers() {
        return teamMembers;
    }

    public void setLeftTeam(boolean leftTeam) {
        this.leftTeam = leftTeam;
        setViewDirection();
    }

    public void addTeamMember(Neanderthal teamMember){
        if(teamMembers.size()<5) {
            teamMembers.add(teamMember);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No more space");
            alert.setHeaderText("Your team reached maximum size");
            alert.setContentText("Teams can only have 5 members");

            alert.showAndWait();
        }
    }

    public void setViewDirection(){
        for (Neanderthal teamMember : teamMembers) {
            teamMember.setFacingRight(leftTeam);
        }
    }
}
