package com.butterworth.superautoneanderthals;

import com.butterworth.superautoneanderthals.repository.TeamRepository;

public class Launcher {
    public static void main(String[] args) {
        TeamRepository.initialize();
        javafx.application.Application.launch(Application.class, args);
    }
}
