package com.game.logic;

import com.game.managers.MenuManager;
import com.game.utilities.Counter;
import com.game.utilities.ScoreWriter;
import com.game.view.game.HUD;
import com.game.view.game.Player;
import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.List;

public class Collision {
    private Position position = new Position();

    private Counter counter;
    private Counter gameCounter;

    private final static int playerRadius = 20;
    private final static int meteorRadius = 20;
    private final static int projectileRadius = 9;
    private int playerLife;
    private int score;

    private List<ImageView> playerProjectilesList;
    private List<ImageView> enemyProjectilesList;
    private List<ImageView> enemiesList;
    private List<ImageView> meteorsList;

    private ImageView[] heartsArray;
    private ImageView[] playerHearts;

    private AnchorPane gamePane;
    private Stage gameStage;

    private AnimationTimer gameTimer;
    private HUD hud;
    private Player player;

    public Collision(Counter counter, Counter gameCounter, Player player, List<ImageView> playerProjectilesList,
                     List<ImageView> enemyProjectilesList, List<ImageView> enemiesList, List<ImageView> meteorsList,
                     ImageView[] heartsArray, ImageView[] playerHearts, AnchorPane gamePane, Stage gameStage, int playerLife,
                     int score, AnimationTimer gameTimer, HUD hud) {
        this.counter = counter;
        this.gameCounter = gameCounter;
        this.player = player;
        this.playerProjectilesList = playerProjectilesList;
        this.enemyProjectilesList = enemyProjectilesList;
        this.enemiesList = enemiesList;
        this.meteorsList = meteorsList;
        this.heartsArray = heartsArray;
        this.playerHearts = playerHearts;
        this.gamePane = gamePane;
        this.gameStage = gameStage;
        this.playerLife = playerLife;
        this.score = score;
        this.gameTimer = gameTimer;
        this.hud = hud;
    }

    public void check() {
        for (ImageView meteor : meteorsList) {
            if (meteorRadius + playerRadius > calculateDistance(player.getPlayerImage().getLayoutX() + 49, meteor.getLayoutX() + 20,
                    player.getPlayerImage().getLayoutY() + 37, meteor.getLayoutY() + 20)) {
                removeLife();
                position.setNewRandomPosition(meteor);
            }
        }
        for (ImageView enemy : enemiesList) {
            if (2 * playerRadius > calculateDistance(player.getPlayerImage().getLayoutX() + 49, enemy.getLayoutX() + 49,
                    player.getPlayerImage().getLayoutY() + 37, enemy.getLayoutY() + 49)) {
                removeLife();
                position.setNewRandomPosition(enemy);
            }
        }
        for (ImageView meteor : meteorsList)
            for (ImageView projectile : playerProjectilesList)
                if (meteorRadius + projectileRadius > calculateDistance(projectile.getLayoutX() + 15, meteor.getLayoutX() + 15,
                        projectile.getLayoutY() + 8, meteor.getLayoutY() + 8)) {
                    position.setNewRandomPosition(meteor);
                    gamePane.getChildren().remove(projectile);
                }
        for (ImageView enemy : enemiesList) {
            for (ImageView projectile : playerProjectilesList)
                if (meteorRadius + projectileRadius > calculateDistance(projectile.getLayoutX() + 15, enemy.getLayoutX() + 49,
                        projectile.getLayoutY() + 15, enemy.getLayoutY() + 49)) {
                    position.setNewRandomPosition(enemy);
                    gamePane.getChildren().remove(projectile);
                    score += 1;
                    String textToSet = "Points: ";
                    hud.setText(textToSet + score);
                }
        }
        for (ImageView enemyProjectile : enemyProjectilesList)
            if (playerRadius + projectileRadius > calculateDistance(enemyProjectile.getLayoutX() + 20, player.getPlayerImage().getLayoutX() + 49,
                    enemyProjectile.getLayoutY() + 15, player.getPlayerImage().getLayoutY() + 49)) {
                removeLife();
                position.rejectImage(enemyProjectile);
            }
        for (ImageView heart : heartsArray) {
            if (playerRadius + 25 > calculateDistance(heart.getLayoutX() + 30, player.getPlayerImage().getLayoutX() + 49,
                    heart.getLayoutY() + 30, player.getPlayerImage().getLayoutY() + 49)) {
                addLife();
                position.setNewCollectable(heart);
            }
        }
    }

    private void removeLife() {
        gamePane.getChildren().remove(playerHearts[playerLife]);
        playerLife--;
        if (playerLife < 0) {
            ScoreWriter scoreWriter = new ScoreWriter();
            scoreWriter.write(score, gameCounter.getCount());
            counter.stopCounting();
            gameCounter.stopCounting();
            gameStage.close();
            new MenuManager();
            gameTimer.stop();
        }
    }

    private void addLife() {
        if (playerLife < 2) {
            gamePane.getChildren().add(playerHearts[playerLife + 1]);
            playerLife++;
        }
    }

    private double calculateDistance(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
