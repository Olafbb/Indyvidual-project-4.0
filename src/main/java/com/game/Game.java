package com.game;

import com.game.managers.MenuManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuManager menuManager = new MenuManager();
    }
}
