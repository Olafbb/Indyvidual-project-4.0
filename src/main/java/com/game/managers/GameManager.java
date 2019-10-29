package com.game.managers;

import com.game.logic.*;
import com.game.utilities.Counter;
import com.game.view.game.GameBackground;
import com.game.view.game.HUD;
import com.game.view.game.Player;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private List<ImageView> playerProjectilesList = new ArrayList<>();
    private List<ImageView> enemyProjectilesList = new ArrayList<>();
    private List<ImageView> enemiesList = new ArrayList<>();
    private List<ImageView> meteorsList = new ArrayList<>();

    private ImageView[] heartsArray = new ImageView[1];
    private ImageView[] playerHeartsArray = new ImageView[3];

    private int playerLife = 2;
    private int score = 0;
    private final static int height = 800;
    private final static int width = 700;

    private HUD hud = new HUD("Points : 0");

    private Counter counter = new Counter(12);
    private Counter gameCounter = new Counter();
    private AnimationTimer gameTimer;

    private AnchorPane gamePane = new AnchorPane();
    private GameBackground gameBackground = new GameBackground(gamePane);
    private Stage gameStage = new Stage();

    private Player player = new Player(width, height, gamePane);
    private Controls controls = new Controls(player, gamePane, playerProjectilesList);
    private PlayerProjectiles playerProjectiles = new PlayerProjectiles(playerProjectilesList);
    private Enemy enemy = new Enemy(enemiesList, enemyProjectilesList, gamePane);
    private Meteors meteors = new Meteors(meteorsList, gamePane);
    private Position position = new Position();
    private Heart heart = new Heart(gamePane, heartsArray, playerHeartsArray);
    private Collision collision = new Collision(counter, gameCounter, player, playerProjectilesList,
            enemyProjectilesList, enemiesList, meteorsList, heartsArray, playerHeartsArray,
            gamePane, gameStage, playerLife, score, gameTimer, hud);
    private Impediment impediment = new Impediment(counter, gamePane);

    public GameManager() {
        initializeStage();
    }

    private void initializeStage() {
        gameBackground.create();
        Scene gameScene = new Scene(gamePane, width, height);
        gameStage.setTitle("Squalaxy");
        gameStage.setScene(gameScene);
        gamePane.getChildren().add(hud);
        controls.createKeyListeners(gameScene);
    }

    public void createNewGame(Stage menuStage) {
        menuStage.hide();
        createGameLoop();
        createGameElements();
        gameStage.show();
    }

    private void createGameElements() {
        player.create();
        enemy.create(5);
        meteors.create(5);
        heart.create();
    }

    private void createGameLoop() {
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gameBackground.move();
                controls.playerManeuvering();
                playerProjectiles.move();
                enemy.move();
                enemy.shoot();
                enemy.moveProjectile();
                meteors.move();
                heart.move();
                position.checkAndRelocateGameElements(height, playerProjectilesList, meteorsList, enemiesList, heartsArray);
                collision.check();
                impediment.makeGameHarder(meteorsList, enemiesList);

            }
        };
        gameTimer.start();
    }
}
