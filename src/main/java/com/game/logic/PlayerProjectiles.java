package com.game.logic;

import javafx.scene.image.ImageView;

import java.util.List;

public class PlayerProjectiles {
    private List<ImageView> projectiles;

    public PlayerProjectiles(List<ImageView> projectiles) {
        this.projectiles = projectiles;
    }

    public void move() {
        for (ImageView projectile : projectiles) {
            projectile.setLayoutY(projectile.getLayoutY() - 10);
        }
    }
}
