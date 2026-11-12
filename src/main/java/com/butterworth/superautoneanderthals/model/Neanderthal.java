package com.butterworth.superautoneanderthals.model;

public abstract class Neanderthal {

    private int id;
    private int initiative;
    private int attack;
    private int hp;
    private int position;
    private boolean facingRight;

    public Neanderthal(int id){
        this.id = id;
        this.position = -1;
    }

    public int getId() {
        return id;
    }

    public int getInitiative() {
        return initiative;
    }

    public int getAttack() {
        return attack;
    }

    public int getHp() {
        return hp;
    }

    public int getPosition() {
        return position;
    }

    public boolean isFacingRight() {
        return facingRight;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public abstract void fight();

    public int moveDistance(){
        if(facingRight){
            return 1;
        }else{
            return -1;
        }
    }
}
