package org.example.crapsgame.model;

import java.Util.Random;


public class Game {
    private int shootCount;
    private int shoot;
    private int point;
    private boolean win;
    private boolean lose;
    Dice dice1, dice2;

    public Game() {
        this.shootCount = 0;
        this.shoot = 0;
        this.point = 0;
        this.win = false;
        this.lose =false;
        this.dice1 = new Dice();
        this.dice2 = new Dice();
    }

    public int getShoot() {
        return this.shoot;
    }

    public int getShootCount() {
        return this.shootCount;
    }

    public int getPoint() {
        return this.point;
    }

    public boolean isWin() {
        return this.win;
    }

    public boolean isLose() {
        return this.lose;
    }

    public int rollDices() {
        this.dice1.roll();
        this.dice2.roll();
        this.shoot = this.dice1.getValue() + this.dice2.getValue();
        this.shootCount++;
        return this.shoot;
    }

    public void play ();

    if ( shoot ==7 || shoot == 11) {
        win = true;
    } else if ( shoot == 2 || shoot == 3 || shoot ==12 ) {
        lose = true;
    }else {
        point = shoot ; // EStablecemos el punto
        while ( !win && !lose ) {
            shoot = rollDices();
            if ( shoot == point) {
                win = true;
            }else if (shoot == 7){
                lose =true;
            }
        }
    }

}
