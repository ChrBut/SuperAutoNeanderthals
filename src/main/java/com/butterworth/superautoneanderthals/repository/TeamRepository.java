package com.butterworth.superautoneanderthals.repository;

import com.butterworth.superautoneanderthals.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamRepository {

    private static TeamRepository instance;
    private List<Team> teamList = new ArrayList<>();

    private TeamRepository(){

    }

    public static synchronized void initialize(){
        if(instance == null){
            instance = new TeamRepository();
        } else {
            throw new IllegalArgumentException("TeamRepository has already been initialized.");
        }
    }

    public static synchronized TeamRepository getInstance(){
        if(instance == null){
            throw new IllegalStateException("TeamRepository has not been initialized.");
        } else {
            return instance;
        }
    }

    public List<Team> getTeamList(){
        return teamList;
    }
}
