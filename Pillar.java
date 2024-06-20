package com.javafx.game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pillar {

    static final double HEIGHT = 200;
    static final double RED_PLATFORM_WIDTH = 8;
    static final double RED_PLATFORM_HEIGHT = 5;
    static final double MIN_WIDTH = 16;
    static final double MAX_WIDTH = 100;

    Rectangle pillar;
    Rectangle red_platform;

    public Pillar(double positionX, double width) {

        double positionY = Engine.STAND_CLIFF_Y;
        double red_platform_x = positionX + (width / 2) - (RED_PLATFORM_WIDTH / 2);

        pillar = new Rectangle();
        pillar.setX(positionX);
        pillar.setY(positionY);
        pillar.setHeight(Pillar.HEIGHT);
        pillar.setWidth(width);
        pillar.setFill(Color.BLACK);

        red_platform = new Rectangle();
        red_platform.setX(red_platform_x);
        red_platform.setY(positionY);
        red_platform.setHeight(RED_PLATFORM_HEIGHT);
        red_platform.setWidth(RED_PLATFORM_WIDTH);
        red_platform.setFill(Color.RED);
    }

    public static Pillar generate_random_reach_pillar() {
        double width = Math.random() * (Pillar.MAX_WIDTH - Pillar.MIN_WIDTH) + Pillar.MIN_WIDTH;
        double MAX_X = Main.SCREEN_WIDTH - width;
        double MIN_X = Engine.STAND_CLIFF_X + 5;
        double positionX = Math.random() * (MAX_X - MIN_X) + MIN_X;
        return new Pillar(positionX, width);
    }

}
