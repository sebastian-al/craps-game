package org.example.crapsgame.model;

public class Game {
    private int shootCount;
    private int shoot;
    private int point;
    private boolean win;
    private boolean lose;
    private Dice dice1, dice2;

    // Constructor del juego
    public Game() {
        this.shootCount = 0;
        this.shoot = 0;
        this.point = 0;
        this.win = false;
        this.lose = false;
        this.dice1 = new Dice();
        this.dice2 = new Dice();
    }

    // Método para reiniciar el juego
    public void reset() {
        this.shootCount = 0;
        this.shoot = 0;
        this.point = 0;
        this.win = false;
        this.lose = false;
        this.dice1 = new Dice();
        this.dice2 = new Dice();
    }

    // Métodos getter
    public Dice getDice1() {
        return dice1;
    }

    public Dice getDice2() {
        return dice2;
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

    // Método para realizar una tirada de dados
    public int rollDices() {
        this.dice1.rollDice();
        this.dice2.rollDice();
        this.shoot = this.dice1.getValue() + this.dice2.getValue();
        this.shootCount++;
        return this.shoot;
    }

    // Método principal que ejecuta el juego
    public String play() {
        // Fase de "come out roll"
        shoot = rollDices();
        System.out.println("Tirada inicial (come out roll): " + shoot);

        if (shoot == 7 || shoot == 11) {
            // Si es 7 o 11, el jugador gana
            win = true;
            return "¡Ganaste! Resultado: " + shoot;
        } else if (shoot == 2 || shoot == 3 || shoot == 12) {
            // Si es 2, 3 o 12, el jugador pierde
            lose = true;
            return "¡Perdiste! Resultado: " + shoot;
        } else {
            // Si el resultado es otro número, se establece el punto
            point = shoot;
            System.out.println("Punto establecido: " + point);
            // Fase de "point roll"
            return playPointRoll();
        }
    }

    // Fase de "point roll"
    private String playPointRoll() {
        while (!win && !lose) {
            shoot = rollDices();
            System.out.println("Tirada de punto: " + shoot);

            if (shoot == point) {
                // Si se obtiene el punto, el jugador gana
                win = true;
                return "¡Ganaste! El punto fue: " + point;
            } else if (shoot == 7) {
                // Si se obtiene un 7, el jugador pierde
                lose = true;
                return "¡Perdiste! Se sacó un 7.";
            }
        }
        return ""; // Nunca llega aquí si el juego terminó
    }
}
