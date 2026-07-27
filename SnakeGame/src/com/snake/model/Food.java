package com.snake.model;

import java.awt.*;
import java.util.Random;

public class Food {
    private Point position;

    public Food() {
        respawn();
    }

    public void respawn() {
        Random random = new Random();

        int x = random.nextInt(30) * 20;
        int y = random.nextInt(30) * 20;

        position = new Point(x, y);
    }

    public Point getPosition() {
        return position;
    }
}
