package org.example.crapsgame.model;

public class Game {
    private int wins;
    private int losses;
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
        this.wins = 0;
        this.losses = 0;
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
        return this.shoot;
    }

    public void rollDice(int value1, int value2) {
        shootCount++;  // Incrementar el número de tiros
        int sum = value1 + value2;

        // Condiciones para ganar o perder
        if (sum == 7 || sum == 10) {
            this.lose = true;
            this.losses++;
        } else {
            this.point = sum;
            this.win = true;
            this.wins++;
        }

        }
    public void resetGame() {
        this.shootCount = 0;
        this.point = 0;
        this.win = false;
        this.lose = false;

}

    public String getLosses() {
    }
}



