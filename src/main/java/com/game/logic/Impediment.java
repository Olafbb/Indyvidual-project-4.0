package com.game.logic;

import com.game.utilities.Counter;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.List;
import java.util.Random;

public class Impediment {
    private Position position = new Position();
    private Random random = new Random();

    private boolean firstImpediment;
    private Counter counter;
    private AnchorPane gamePane;

    public Impediment(Counter counter, AnchorPane gamePane) {
        this.counter = counter;
        this.gamePane = gamePane;
    }

    public void makeGameHarder(List<ImageView> meteorsList, List<ImageView> enemiesList) {
        if (counter.getCount() == 9) {
            firstImpediment = false;
        }
        if (counter.getCount() == 10 && !firstImpediment) {
            for (int i = 0; i < random.nextInt(2) + 1; i++) {
                int a = random.nextInt(2);
                if (a == 0) {
                    ImageView meteor = new ImageView("file:src/main/resources/meteor_model_3.png");
                    meteorsList.add(meteor);
                    position.setNewRandomPosition(meteor);
                    gamePane.getChildren().add(meteor);
                }
                if (a == 1) {
                    ImageView meteor = new ImageView("file:src/main/resources/meteor_model_2.png");
                    meteorsList.add(meteor);
                    position.setNewRandomPosition(meteor);
                    gamePane.getChildren().add(meteor);
                }
                if (a == 2) {
                    ImageView meteor = new ImageView("file:src/main/resources/meteor_model_1.png");
                    meteorsList.add(meteor);
                    position.setNewRandomPosition(meteor);
                    gamePane.getChildren().add(meteor);
                }
                ImageView enemy = new ImageView("file:src/main/resources/enemy_model.png");
                enemiesList.add(enemy);
                position.setNewRandomPosition(enemy);
                gamePane.getChildren().add(enemy);
            }
            firstImpediment = true;
            if (counter.getCount() == 11) {
                firstImpediment = false;
            }
        }
    }
}
