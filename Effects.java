package com.javafx.game;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Effects {

    public static Animation Bounce(Node node) {
        // Create a ScaleTransition for the node (enlarging effect)
        ScaleTransition scaleEnlarge = new ScaleTransition(Duration.seconds(0.1), node);
        scaleEnlarge.setFromX(1.0);
        scaleEnlarge.setToX(1.2);
        scaleEnlarge.setFromY(1.0);
        scaleEnlarge.setToY(1.2);

        // Create a ScaleTransition for the node (returning to original size)
        ScaleTransition scaleOriginal = new ScaleTransition(Duration.seconds(0.1), node);
        scaleOriginal.setFromX(1.2);
        scaleOriginal.setToX(1.0);
        scaleOriginal.setFromY(1.2);
        scaleOriginal.setToY(1.0);

        // Create a ParallelTransition to combine both transitions
        ParallelTransition parallelTransition = new ParallelTransition(scaleEnlarge, scaleOriginal);

        // Play the parallel transition
        parallelTransition.play();
        return parallelTransition;
    }

    public static Animation move_left(double distance, Runnable onFinished, Node... nodes) {
        final double SPEED = 300; // 1x 2x 3x 4x 5x
        ParallelTransition parallelTransition = new ParallelTransition();
        for (Node node : nodes) {
            TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), node);
            transition.setByX(-distance); // Move the node to the left by the specified distance
            parallelTransition.getChildren().add(transition);
        }
        parallelTransition.setOnFinished(event -> {
            if (onFinished != null) {
                onFinished.run(); // Execute the next instruction
            }
        });
        parallelTransition.play();
        return parallelTransition;
    }

    public static Animation move_right(Runnable onFinished, double distance, Node... nodes) {
        final double SPEED = 150; // 1x 2x 3x 4x 5x
        ParallelTransition parallelTransition = new ParallelTransition();
        for (Node node : nodes) {
            TranslateTransition transition = new TranslateTransition(Duration.seconds(distance / SPEED), node);
            transition.setByX(distance); // Move the node to the left by the specified distance
            parallelTransition.getChildren().add(transition);
        }
        parallelTransition.setOnFinished(event -> {
            if (onFinished != null) {
                onFinished.run(); // Execute the next instruction
            }
        });
        return parallelTransition;
    }

    public static Animation move_up_down(Node node, int distance) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), node);
        translateTransition.setByY(-distance); // Set the distance to move up and down
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE); // Set indefinite cycle
        translateTransition.setAutoReverse(true); // Move back and forth
        translateTransition.play();
        return translateTransition;
    }

    private static List<Image> make_frames(String folderName) {
        String folderPath = "animations/" + folderName + "/ (";
        List<Image> frames = new ArrayList<>();
        int i = 1;
        while (true) {
            InputStream stream = Effects.class.getResourceAsStream(folderPath + i + ").png");
            if (stream == null) {
                break; // No more frames found
            }
            Image image = new Image(stream);
            frames.add(image);
            i++;
        }
        return frames;
    }

    public static Animation animation(ImageView imageView, String folderName) {

        List<Image> frames_list;
        frames_list = make_frames(folderName);
        Timeline timeline = new Timeline();
        for (int i = 0; i < frames_list.size(); i++) {
            Image frame = frames_list.get(i);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(100 * (i + 1)), e -> imageView.setImage(frame));
            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.setCycleCount(Timeline.INDEFINITE); // Set the cycle count as needed
        // timeline.setCycleCount(1);
        return timeline;
    }

    public static Animation move_down(double distance, Node... nodes) {
        final double SPEED = 400; // 1x 2x 3x 4x 5x
        ParallelTransition parallelTransition = new ParallelTransition();
        for (Node node : nodes) {
            TranslateTransition transition = new TranslateTransition(Duration.seconds(distance / SPEED), node);
            transition.setToY(distance); // Move the node to the left by the specified distance
            parallelTransition.getChildren().add(transition);
        }
        return parallelTransition;
    }

}
