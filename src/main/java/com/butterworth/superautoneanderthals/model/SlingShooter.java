package com.butterworth.superautoneanderthals.model;

public class SlingShooter extends Neanderthal{

    public SlingShooter(long id){
        super(id);
        setInitiative(3);
        setAttack(1);
        setHp(1);
    }

    @Override
    public void fight() {

    }

}
