package com.javafx.game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Stick {

    static final double WIDTH = 4;
    static final double GROW_RATE = 3; // 1x 2x 3x 4x 5x
    static final double ROTATE_RATE = 2; // 1x 2x 3x 4x 5x
    static final double MAX_HEIGHT = 400;

    Rectangle rectangle;
    private Timeline growingTimeline;

    public Stick() {
        // double positionX = pillar_stand.pillar.getX() +
        // pillar_stand.pillar.getWidth() - Stick.WIDTH;

        double positionX = Engine.STAND_CLIFF_X - Stick.WIDTH;
        double positionY = Engine.STAND_CLIFF_Y + 0.2; // Y position of the pillar
        this.rectangle = new Rectangle();
        this.rectangle.setX(positionX);
        this.rectangle.setY(positionY);
        this.rectangle.setHeight(0);
        this.rectangle.setWidth(Stick.WIDTH);
        this.rectangle.setFill(Color.BLACK);
    }

    public void grow() {
        if (growingTimeline == null) {
            growingTimeline = new Timeline(
                    new KeyFrame(Duration.millis(10 / Stick.GROW_RATE), e -> increaseHeight()));
            growingTimeline.setCycleCount(Animation.INDEFINITE);
            growingTimeline.play();
        }
    }

    public boolean stop_grow() {
        if (growingTimeline != null) {
            growingTimeline.stop();
            growingTimeline = null;
            return true;
        }
        return false;
    }

    private void increaseHeight() {
        if (rectangle.getHeight() >= Stick.MAX_HEIGHT) {
            growingTimeline.stop();
            return;
        }
        double newY = rectangle.getY() - 0.5; // Move the stick upwards
        double newHeight = rectangle.getHeight() + 0.5; // Increase the height
        rectangle.setY(newY);
        rectangle.setHeight(newHeight);
    }

    public void rotate(Runnable onFinished) {
        Rotate rotate = new Rotate();
        rotate.setPivotX(rectangle.getX() + rectangle.getWidth() / 2); // Pivot X at center
        rotate.setPivotY(rectangle.getY() + rectangle.getHeight()); // Pivot Y at bottom
        rectangle.getTransforms().add(rotate); // Add rotation to stick

        // Create a Timeline to rotate the stick

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1 / Stick.ROTATE_RATE), new KeyValue(rotate.angleProperty(), 90)));

        timeline.setOnFinished(event -> {
            if (onFinished != null) {
                onFinished.run(); // Execute the next instruction
            }
        });
        timeline.play(); // Play the animation
    }

}
