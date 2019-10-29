package com.game.view.game;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

public class HUD extends Label {

    public HUD(String text) {
        setPrefWidth(125);
        setPrefHeight(100);
        String scoreBackground = "file:src/main/resources/HUD_score_background_model.png";
        BackgroundImage backgroundImage = new BackgroundImage(new Image(scoreBackground, 150,
                50, false, true), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        setBackground(new Background(backgroundImage));
        setAlignment(Pos.TOP_RIGHT);
        setPadding(new Insets(10, 20, 10, 15));
        setFont(Font.font("Verdana", 15));
        setText(text);
        setLayoutX(550);
        setLayoutY(60);

    }
}
