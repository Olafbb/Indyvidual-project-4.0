package com.game.logic;

import com.game.view.game.Player;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.List;

public class Controls {
    private Player player;
    private List<ImageView> projectiles;
    private AnchorPane gamePane;

    private boolean isLeftKeyPressed;
    private boolean isRightKeyPressed;
    private boolean isUpKeyPressed;
    private boolean isDownKeyPressed;

    public Controls(Player player, AnchorPane gamePane, List<ImageView> projectiles) {
        this.player = player;
        this.gamePane = gamePane;
        this.projectiles = projectiles;
    }

    public void createKeyListeners(Scene gameScene) {
        Duration firingInterval = Duration.millis(300);
        Timeline firing = new Timeline(
                new KeyFrame(Duration.ZERO, event -> {
                    ImageView projectile = new ImageView("file:src/main/resources/projectile_model.png");
                    projectile.setLayoutX(player.getPlayerImage().getLayoutX() + 18);
                    projectile.setLayoutY(player.getPlayerImage().getLayoutY() - 50);
                    gamePane.getChildren().add(projectile);
                    projectiles.add(projectile);
                }),
                new KeyFrame(firingInterval));
        firing.setCycleCount(Animation.INDEFINITE);

        gameScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                isLeftKeyPressed = true;
            } else if (event.getCode() == KeyCode.RIGHT) {
                isRightKeyPressed = true;
            } else if (event.getCode() == KeyCode.UP) {
                isUpKeyPressed = true;
            } else if (event.getCode() == KeyCode.DOWN) {
                isDownKeyPressed = true;
            } else if (event.getCode() == KeyCode.SPACE && firing.getStatus() != Animation.Status.RUNNING) {
                firing.playFromStart();
            }
        });
        gameScene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                isLeftKeyPressed = false;
            } else if (event.getCode() == KeyCode.RIGHT) {
                isRightKeyPressed = false;
            } else if (event.getCode() == KeyCode.UP) {
                isUpKeyPressed = false;
            } else if (event.getCode() == KeyCode.DOWN) {
                isDownKeyPressed = false;
            } else if (event.getCode() == KeyCode.SPACE) {
                firing.stop();
            }
        });
    }

    public void playerManeuvering() {
        int angle = 0;
        if (isLeftKeyPressed && !isRightKeyPressed) {
            angle -= 12;
            player.getPlayerImage().setRotate(angle);
            if (player.getPlayerImage().getLayoutX() > 5) {
                player.getPlayerImage().setLayoutX(player.getPlayerImage().getLayoutX() - 10);
            }
        }
        if (isRightKeyPressed && !isLeftKeyPressed) {
            angle += 12;
            player.getPlayerImage().setRotate(angle);
            if (player.getPlayerImage().getLayoutX() < 650) {
                player.getPlayerImage().setLayoutX(player.getPlayerImage().getLayoutX() + 10);
            }
        }

        if (isUpKeyPressed && !isDownKeyPressed) {
            if (player.getPlayerImage().getLayoutY() > 0)
                player.getPlayerImage().setLayoutY(player.getPlayerImage().getLayoutY() - 10);
        }

        if (isDownKeyPressed && !isUpKeyPressed) {
            if (player.getPlayerImage().getLayoutY() < 750)
                player.getPlayerImage().setLayoutY(player.getPlayerImage().getLayoutY() + 10);
        }
        if (!isRightKeyPressed && !isLeftKeyPressed) {
            if (angle < 0) {
                angle += 10;
            } else if (angle > 0) {
                angle -= 10;
            }
            player.getPlayerImage().setRotate(angle);
        }
        if (isRightKeyPressed && isLeftKeyPressed) {
            if (angle < 0) {
                angle += 5;
            } else if (angle > 0) {
                angle -= 5;
            }
            player.getPlayerImage().setRotate(angle);
        }
    }
}
