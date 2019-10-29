package com.game.extended;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ExtendedButton extends Button {

    private final String buttonReleased = "-fx-background-color: rgba(200,194,206,0.98);";

    public ExtendedButton(String text) {
        setText(text);
        setFont(Font.font("Verdana", 23));
        setPrefWidth(190);
        setPrefHeight(49);
        setStyle(buttonReleased);
        initializeButton();
    }

    private void setButtonPressed() {
        String buttonPressed = "-fx-background-color: white;";
        setStyle(buttonPressed);
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 4);
    }

    private void setButtonReleased() {
        setStyle(buttonReleased);
        setPrefHeight(49);
        setLayoutY(getLayoutY() - 4);
    }

    private void initializeButton() {
        setOnMousePressed(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                setButtonPressed();
            }
        });
        setOnMouseReleased(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                setButtonReleased();
            }
        });
        setOnMouseEntered(event -> {
            DropShadow dropShadow = new DropShadow();
            dropShadow.setColor(Color.WHITE);
            setEffect(dropShadow);
        });
        setOnMouseExited(event -> setEffect(null));
    }
}
