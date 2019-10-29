package com.game.logic;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.List;
import java.util.Random;

public class Meteors {
    private Random random = new Random();
    private Position position = new Position();

    private List<ImageView> meteors;
    private AnchorPane gamePane;

    public Meteors(List<ImageView> meteors, AnchorPane gamePane) {
        this.meteors = meteors;
        this.gamePane = gamePane;
    }

    public void create(int number) {
        for (int i = 0; i < number; i++) {
            int a = random.nextInt(2);
            if (a == 0)
                meteors.add(new ImageView("file:src/main/resources/meteor_model_1.png"));
            if (a == 1)
                meteors.add(new ImageView("file:src/main/resources/meteor_model_2.png"));
            if (a == 2)
                meteors.add(new ImageView("file:src/main/resources/meteor_model_3.png"));
        }
        for (ImageView meteor : meteors) {
            position.setNewRandomPosition(meteor);
            gamePane.getChildren().add(meteor);
        }
    }

    public void move() {
        for (ImageView meteor : meteors) {
            meteor.setLayoutY(meteor.getLayoutY() + 5);
            meteor.setRotate(meteor.getRotate() + 10);
        }
    }
}
