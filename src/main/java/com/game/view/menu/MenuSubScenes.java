package com.game.view.menu;

import com.game.extended.ExtendedSubScene;
import com.game.utilities.FileReader;
import javafx.scene.layout.AnchorPane;

public class MenuSubScenes {
    private AnchorPane anchorPane;

    private ExtendedSubScene playSubScene;
    private ExtendedSubScene scoresSubScene;
    private ExtendedSubScene helpSubScene;
    private ExtendedSubScene creditsSubScene;
    private ExtendedSubScene sceneToHide;

    public MenuSubScenes(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public ExtendedSubScene getPlaySubScene() {
        return playSubScene;
    }

    public ExtendedSubScene getScoresSubScene() {
        return scoresSubScene;
    }

    public ExtendedSubScene getHelpSubScene() {
        return helpSubScene;
    }

    public ExtendedSubScene getCreditsSubScene() {
        return creditsSubScene;
    }

    void showSubScenes(ExtendedSubScene subScene) {
        if (sceneToHide != null) {
            sceneToHide.moveSubScene();
        }
        subScene.moveSubScene();
        sceneToHide = subScene;
    }

    public void createSubScenes() {
        playSubScene = new ExtendedSubScene();
        anchorPane.getChildren().add(playSubScene);

        scoresSubScene = new ExtendedSubScene(new FileReader().getFileContent("scores.txt"));
        anchorPane.getChildren().add(scoresSubScene);
        helpSubScene = new ExtendedSubScene();
        anchorPane.getChildren().add(helpSubScene);

        creditsSubScene = new ExtendedSubScene();
        anchorPane.getChildren().add(creditsSubScene);

        createSubScene();
    }

    private void createSubScene() {
        ExtendedSubScene subScene = new ExtendedSubScene();
        anchorPane.getChildren().add(subScene);
        subScene.getPane().getChildren().add(subScene);
    }


}
