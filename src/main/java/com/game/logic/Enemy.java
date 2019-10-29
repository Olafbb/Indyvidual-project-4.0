package com.game.logic;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.List;
import java.util.Random;

public class Enemy {
    private Random random = new Random();
    private AnchorPane gamePane;

    private List<ImageView> enemies;
    private List<ImageView> enemyProjectiles;

    public Enemy(List<ImageView> enemies, List<ImageView> enemyProjectiles, AnchorPane gamePane) {
        this.enemies = enemies;
        this.enemyProjectiles = enemyProjectiles;
        this.gamePane = gamePane;
    }

    public void create(int number) {
        Position position = new Position();
        for (int i = 0; i < number; i++)
            enemies.add(new ImageView("file:src/main/resources/enemy_model.png"));
        for (ImageView enemy : enemies) {
            position.setNewRandomPosition(enemy);
            gamePane.getChildren().add(enemy);
        }
    }

    public void move() {
        for (ImageView enemy : enemies) {
            enemy.setLayoutY(enemy.getLayoutY() + (random.nextInt(8) -
                    random.nextInt(6)));
            enemy.setLayoutX(enemy.getLayoutX() + (random.nextInt(17) -
                    random.nextInt(17)));
        }
    }

    public void shoot() {
        for (ImageView enemy : enemies) {
            if (random.nextInt(150) - (random.nextInt(150) + 130) > 0) {
                ImageView enemyProjectile = new ImageView("file:src/main/resources/enemy_projectile_model.png");
                enemyProjectile.setLayoutX(enemy.getLayoutX() + 18);
                enemyProjectile.setLayoutY(enemy.getLayoutY());
                gamePane.getChildren().add(enemyProjectile);
                enemyProjectiles.add(enemyProjectile);
            }
        }
    }

    public void moveProjectile() {
        for (ImageView enemyProjectile : enemyProjectiles) {
            enemyProjectile.setLayoutY(enemyProjectile.getLayoutY() + 10);
        }
    }
}

