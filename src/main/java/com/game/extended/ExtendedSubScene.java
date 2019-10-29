package com.game.extended;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class ExtendedSubScene extends SubScene {

    private boolean isHidden;

    public ExtendedSubScene() {
        super(new AnchorPane(), 225, 375);
        prefWidth(375);
        prefHeight(225);

        BackgroundImage image = new BackgroundImage(new Image("file:src/main/resources/extendedSubScene_model.png", 225, 375, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(image));
        setLayoutX(460);
        setLayoutY(1400);

        isHidden = true;

    }
    public ExtendedSubScene(String text) {
        super(new AnchorPane(), 225, 375);
        prefWidth(375);
        prefHeight(225);

        BackgroundImage image = new BackgroundImage(new Image("file:src/main/resources/extendedSubScene_model.png", 225, 375, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(image));
        ExtendedLabel label = new ExtendedLabel(text,225,0,0,0);
        root2.getChildren().add(label);
        setLayoutX(460);
        setLayoutY(1400);

        isHidden = true;

    }
    public ExtendedSubScene(String text, int number) {
        super(new AnchorPane(), 225, 375);
        prefWidth(375);
        prefHeight(225);

        BackgroundImage image = new BackgroundImage(new Image("file:src/main/resources/extendedSubScene_model.png", 225, 375, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(image));


        ExtendedLabel label = new ExtendedLabel(text,225,0,0,0);
        root2.getChildren().add(label);
        setLayoutX(460);
        setLayoutY(1400);

        isHidden = true;

    }

    public void moveSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.5));
        transition.setNode(this);

        if (isHidden) {
            transition.setToY(-1000);
            isHidden = false;
        } else {
            transition.setToY(0);
            isHidden = true;
        }
        transition.play();
    }

    public AnchorPane getPane() {
        return (AnchorPane) this.getRoot();
    }
}