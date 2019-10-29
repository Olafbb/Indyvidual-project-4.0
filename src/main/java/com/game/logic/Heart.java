package com.game.logic;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Heart {
    private Position position = new Position();
    private AnchorPane gamePane;

    private ImageView[] playerHearts;
    private ImageView[] hearts;

    public Heart(AnchorPane gamePane, ImageView[] hearts, ImageView[] playerHearts) {
        this.gamePane = gamePane;
        this.hearts = hearts;
        this.playerHearts = playerHearts;
    }

    public void create() {
        for (int i = 0; i < playerHearts.length; i++) {
            playerHearts[i] = new ImageView("file:src/main/resources/heart_model.png");
            playerHearts[i].setLayoutX(550 + (i * 50));
            playerHearts[i].setLayoutY(10);
            gamePane.getChildren().add(playerHearts[i]);
        }
        for (int i = 0; i < hearts.length; i++) {
            hearts[i] = new ImageView("file:src/main/resources/heart_model.jpg");
            position.setNewRandomPosition(hearts[i]);
            gamePane.getChildren().add(hearts[i]);
        }
    }

    public void move() {
        for (ImageView heart : hearts) {
            heart.setLayoutY(heart.getLayoutY() + 2);
        }
    }

}
