package com.game.view.menu;

import com.game.extended.ExtendedButton;
import com.game.extended.ExtendedSubScene;
import com.game.managers.GameManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class MenuButtons {
    private AnchorPane anchorPane;
    private Stage mainStage;
    private List<ExtendedButton> menuButtons = new ArrayList<>();

    private ExtendedButton playButton = new ExtendedButton("PLAY");
    private ExtendedButton scoresButton = new ExtendedButton("SCORES");
    private ExtendedButton helpButton = new ExtendedButton("HELP");
    private ExtendedButton creditsButton = new ExtendedButton("CREDITS");
    private ExtendedButton exitButton = new ExtendedButton("EXIT");

    public MenuButtons(AnchorPane anchorPane, Stage mainStage) {
        this.anchorPane = anchorPane;
        this.mainStage = mainStage;
    }

    public ExtendedButton getScoresButton() {
        return scoresButton;
    }

    public ExtendedButton getHelpButton() {
        return helpButton;
    }

    public ExtendedButton getCreditsButton() {
        return creditsButton;
    }

    public void createButtons() {
        createPlayButton();
        createScoresButton();
        createHelpButton();
        createCreditsButton();
        createExitButton();
    }

    private void addMenuButtons(ExtendedButton button) {
        button.setLayoutX(250);
        button.setLayoutY((475) + menuButtons.size() * 60);
        menuButtons.add(button);
        anchorPane.getChildren().add(button);
    }

    public void setButtonSubScene(ExtendedButton button, MenuSubScenes subScenes, ExtendedSubScene subScene) {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                subScenes.showSubScenes(subScene);
            }
        });
    }

    private void createPlayButton() {
        addMenuButtons(playButton);
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameManager gameManager = new GameManager();
                gameManager.createNewGame(mainStage);
            }
        });
    }

    private void createScoresButton() {
        addMenuButtons(scoresButton);

    }

    private void createHelpButton() {

        addMenuButtons(helpButton);

    }

    private void createCreditsButton() {
        addMenuButtons(creditsButton);

    }

    private void createExitButton() {
        addMenuButtons(exitButton);
        exitButton.setOnAction(event -> mainStage.close());
    }

}
