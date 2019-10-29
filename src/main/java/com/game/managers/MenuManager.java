package com.game.managers;

import com.game.view.menu.MenuButtons;
import com.game.view.menu.MenuSubScenes;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MenuManager {
    private AnchorPane anchorPane = new AnchorPane();

    public MenuManager() {

        Scene mainScene = new Scene(anchorPane, 700, 800);
        Stage mainStage = new Stage();
        mainStage.setTitle("Squalaxy");
        mainStage.setScene(mainScene);
        mainStage.show();

        MenuSubScenes menuSubScenes = new MenuSubScenes(anchorPane);
        menuSubScenes.createSubScenes();
        MenuButtons menuButtons = new MenuButtons(anchorPane,mainStage);
        menuButtons.createButtons();
        menuButtons.setButtonSubScene(menuButtons.getScoresButton(),menuSubScenes,menuSubScenes.getScoresSubScene());
        menuButtons.setButtonSubScene(menuButtons.getHelpButton(),menuSubScenes,menuSubScenes.getHelpSubScene());
        menuButtons.setButtonSubScene(menuButtons.getCreditsButton(),menuSubScenes,menuSubScenes.getCreditsSubScene());

        createMenuLogo();
        createMenuBackground();


    }

    private void createMenuBackground() {
        Image imageBack = new Image("file:src/main/resources/background_model.png");
        BackgroundImage background = new BackgroundImage(imageBack, BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false));

        anchorPane.setBackground(new Background(background));
    }

    private void createMenuLogo() {
        ImageView logo = new ImageView("file:src/main/resources/logo_model.png");
        logo.setLayoutX(145);
        logo.setLayoutY(200);
        anchorPane.getChildren().add(logo);
    }

}
