package com.butterworth.superautoneanderthals.model;

public class Match {

    private Team teamLeft;
    private Team teamRight;
    private Neanderthal[] battleground = new Neanderthal[20];

    public Match(Team teamLeft, Team teamRight){
        this.teamLeft = teamLeft;
        this.teamRight = teamRight;

        this.teamLeft.setLeftTeam(true);
        this.teamRight.setLeftTeam(false);

        placeTeams();
    }

    private void placeTeams(){
        //find starting point for teamLeft battleground[4 to 9]
        int startingPointL = (int)((Math.random()*5)+4);
        for(int i=0; i<teamLeft.getTeamMembers().size(); i++){
            teamLeft.getTeamMembers().get(i).setPosition(startingPointL-i);
        }
        //find startingPoint for teamRight battleground[10 to 15]
        int startingPointR = (int)((Math.random()*5)+10);
        for(int i=0; i<teamRight.getTeamMembers().size(); i++){
            teamRight.getTeamMembers().get(i).setPosition(startingPointR+i);
        }
    }

    public void move(){
        for(int i=0; i<teamLeft.getTeamMembers().size(); i++){
            if(battleground[teamLeft.getTeamMembers().get(i).getPosition()+1] == null && teamLeft.getTeamMembers().get(i).getPosition() < 19){
                teamLeft.getTeamMembers().get(i).setPosition(teamLeft.getTeamMembers().get(i).getPosition()+1);
            }
        }

        for(int i=0; i<teamRight.getTeamMembers().size(); i++){
            if(battleground[teamRight.getTeamMembers().get(i).getPosition()-1] == null && teamRight.getTeamMembers().get(i).getPosition() > 0){
                teamRight.getTeamMembers().get(i).setPosition(teamRight.getTeamMembers().get(i).getPosition()-1);
            }
        }
    }

}
