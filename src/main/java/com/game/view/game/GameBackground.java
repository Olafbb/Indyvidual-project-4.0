package com.game.view.game;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class GameBackground {
    private AnchorPane gamePane;
    private GridPane gridPane1;
    private GridPane gridPane2;

    public GameBackground(AnchorPane gamePane) {
        this.gamePane = gamePane;

    }

    public void create() {
        gridPane1 = new GridPane();
        gridPane2 = new GridPane();
        for (int i = 0; i < 12; i++) {
            ImageView backgroundImage1 = new ImageView("file:src/main/resources/background_model.png");
            ImageView backgroundImage2 = new ImageView("file:src/main/resources/background_model.png");

            GridPane.setConstraints(backgroundImage1, i % 3, i / 3);
            GridPane.setConstraints(backgroundImage2, i % 3, i / 3);

            gridPane1.getChildren().add(backgroundImage1);
            gridPane2.getChildren().add(backgroundImage2);
        }
        gridPane2.setLayoutY(-800);
        gamePane.getChildren().addAll(gridPane1, gridPane2);
    }

    public void move() {
        gridPane1.setLayoutY(gridPane1.getLayoutY() + 2);
        gridPane2.setLayoutY(gridPane2.getLayoutY() + 2);

        if (gridPane1.getLayoutY() >= 800) {
            gridPane1.setLayoutY(-800);
        }
        if (gridPane2.getLayoutY() >= 800) {
            gridPane2.setLayoutY(-800);
        }
    }
}
