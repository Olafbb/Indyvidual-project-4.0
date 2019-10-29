package com.game.logic;

import javafx.scene.image.ImageView;

import java.util.List;
import java.util.Random;

public class Position {
    private Random random = new Random();

    void setNewRandomPosition(ImageView image) {

        image.setLayoutX(random.nextInt(645) + 5);
        image.setLayoutY(random.nextInt(500) - 600);
    }

    void setNewCollectable(ImageView image) {
        image.setLayoutX(random.nextInt(645) + 5);
        image.setLayoutY(random.nextInt(1500) - 4000);
    }

    void rejectImage(ImageView image) {
        image.setLayoutY(-800);
    }

    public void checkAndRelocateGameElements(int height, List<ImageView> playerProjectilesList, List<ImageView> meteors, List<ImageView> enemies, ImageView[] hearts) {
        for (ImageView meteor : meteors) {
            if (meteor.getLayoutY() > height) {
                setNewRandomPosition(meteor);
            }
        }
        for (ImageView enemy : enemies) {
            if (enemy.getLayoutY() > height) {
                setNewRandomPosition(enemy);
            }
        }
        for (ImageView enemy : enemies) {
            if (enemy.getLayoutX() > 700) {
                setNewRandomPosition(enemy);
            }
            if (enemy.getLayoutX() < -50) {
                setNewRandomPosition(enemy);
            }
        }
        for (ImageView heart : hearts) {
            if (heart.getLayoutY() > height)
                setNewCollectable(heart);
        }

        for (ImageView projectile : playerProjectilesList) {
            if(projectile.getLayoutY() < 0) {
                rejectImage(projectile);
            }
        }
    }
}
