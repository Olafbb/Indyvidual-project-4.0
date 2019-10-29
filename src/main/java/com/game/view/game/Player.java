package com.game.view.game;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Player {

    private int width;
    private int height;
    private AnchorPane gamePane;

    private ImageView playerImage = new ImageView("file:src/main/resources/player_model.png");

    public Player(int width, int height, AnchorPane gamePane) {
        this.width = width;
        this.height = height;
        this.gamePane = gamePane;
    }

    public ImageView getPlayerImage() {
        return playerImage;
    }

    public void create() {
        playerImage.setLayoutX((width / 2) * 0.92);
        playerImage.setLayoutY(height - 50);
        gamePane.getChildren().add(playerImage);
    }
}
