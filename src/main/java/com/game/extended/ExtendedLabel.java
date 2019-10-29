package com.game.extended;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class ExtendedLabel extends Label {
    public ExtendedLabel(String text, int width, int height, int x, int y) {
        setLayoutX(x);
        setLayoutY(y);
        setPrefWidth(width);
        setPrefHeight(height);

        setAlignment(Pos.TOP_LEFT);
        setPadding(new Insets(10, 20, 10, 15));
        setFont(Font.font("Verdana", 15));
        setText(text);

    }
}
