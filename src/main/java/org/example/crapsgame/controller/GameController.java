package org.example.crapsgame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.example.crapsgame.model.Dice;
import org.example.crapsgame.model.Game;

public class GameController {

    @FXML
    private Label pointLabel, shootLabel, shotLabel1, pointLabel1;

    @FXML
    private ImageView dice1ImageView, dice2ImageView;

    private Game game;

    public GameController() {
        this.game = new Game();
    }


    @FXML
    public void onHandleButtonRollTheDice(ActionEvent event) {
        int shoot = game.rollDices();

        shootLabel.setText(String.valueOf(shoot));

        dice1ImageView.setImage(game.getDice1().getDiceImage());
        dice2ImageView.setImage(game.getDice2().getDiceImage());


        if (game.isWin()) {
            pointLabel.setText("¡Ganaste!");
            shotLabel1.setText("Juegos ganados");
            pointLabel1.setText(String.valueOf(game.getShootCount()));
        } else if (game.isLose()) {
            pointLabel.setText("Perdiste...");
            shotLabel1.setText("Juegos perdidos");
            pointLabel1.setText(String.valueOf(game.getShootCount()));
        } else {

            pointLabel.setText("Punto: " + game.getPoint());
        }

        if (game.isWin() || game.isLose()) {
            resetGame();
        }
    }

    private void resetGame() {
        game.reset();
        shootLabel.setText("0");
        pointLabel.setText("...");
        shotLabel1.setText("Juegos ganados");
        pointLabel1.setText("0");
        dice1ImageView.setImage(null);
        dice2ImageView.setImage(null);
    }

}
