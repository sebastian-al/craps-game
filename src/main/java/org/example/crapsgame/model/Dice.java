package org.example.crapsgame.model;

import javafx.scene.image.Image;
import java.io.InputStream;

public class Dice {
    private static final String PATH = "/org/example/crapsgame/images/dices/";
    private Image diceImage;
    private int value;

    public Dice() {
        this.value = 0;
        this.diceImage = loadImage("dice1.png");
    }

    public Image getDiceImage() {
        return diceImage;
    }

    public int getValue() {
        return this.value;
    }

    public void rollDice() {
        this.value = (int)(Math.random() * 6) + 1;

        String imagePath = "dice" + this.value + ".png";
        this.diceImage = loadImage(imagePath);
    }
    private Image loadImage(String imageName) {
        String imagePath = PATH + imageName;
        InputStream inputStream = getClass().getResourceAsStream(imagePath);

        if (inputStream == null) {
            System.err.println("Error: No se pudo cargar la imagen desde la ruta: " + imagePath);
            return null;
        } else {
            return new Image(inputStream);
        }
    }
}

