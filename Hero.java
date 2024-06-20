package com.javafx.game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Hero {
    ImageView imageview;
    Animation idle_animation;
    Animation running_animation_basic;
    Animation falling_animation;
    Timeline running_timeline;
    boolean is_down;
    static final double DIMESION = 50; // image is square so width = height // 50x50
    static final double X_OFFSET = 30; // + to move left - to move right
    static final double Y_OFFSET = 7; // 1.5 * Stick.WIDTH // - to move up + to move down
    // PNG witth analysis 128 x 128 : 16-64-48

    public Hero() {

        this.imageview = new ImageView(new Image(getClass().getResourceAsStream("bitmaps/HERO.png")));
        this.imageview.setFitHeight(Hero.DIMESION);
        this.imageview.setFitWidth(Hero.DIMESION);
        this.imageview.setX(Engine.STAND_CLIFF_X - X_OFFSET);
        this.imageview.setY(Engine.STAND_CLIFF_Y - Hero.DIMESION + Y_OFFSET);
        this.idle_animation = Effects.animation(imageview, "Idle");
        this.running_animation_basic = Effects.animation(imageview, "Run");
        this.falling_animation = Effects.move_down(Pillar.HEIGHT + Hero.DIMESION, imageview);
        idle_animation.play();
    }

    public void run(Engine engine, double distance, Runnable onFinished) {

        Timeline timeline = new Timeline(); // Initialize the timeline variable

        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(10), e -> {
            double xCoordinate = imageview.getTranslateX() + imageview.getX() + Hero.DIMESION / 2;
            double cherry_start_x = engine.cherry.imageview.getX();
            double cherry_end_x = cherry_start_x + Cherry.DIMESION;
            if (is_down && engine.is_cherry_capture == false) {
                if (cherry_start_x < xCoordinate && xCoordinate < cherry_end_x) {
                    engine.is_cherry_capture = true;
                    engine.cherry.imageview.setX(-50);
                }
            }
            if (is_down && xCoordinate > engine.reach_pillar.pillar.getX()) {
                engine.game_over();
                timeline.stop();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);

        Animation moving_right_animation = Effects.move_right(() -> {
        }, distance, imageview);

        moving_right_animation.setOnFinished(event -> {
            if (onFinished != null) {
                timeline.stop();
                running_animation_basic.stop();
                idle_animation.play();
                onFinished.run(); // Execute the next instruction
            }
        });

        idle_animation.stop();
        timeline.play();
        moving_right_animation.play();
        running_animation_basic.play();
    }

    public boolean can_flip(Pillar reach_pillar) {

        double hero_cur_position_x = imageview.getTranslateX();
        if (5 < hero_cur_position_x
                && hero_cur_position_x < reach_pillar.pillar.getX() - Engine.STAND_CLIFF_X + 10) {
            return true;
        }
        return false;
    }

    public void flip(Pillar reach_pillar) {
        // make image flip again and again
        if (can_flip(reach_pillar)) {
            int cur_state = is_down ? -1 : 1;
            imageview.setScaleY(-cur_state);
            Sound.flip();
            double FLIP_Y_OFFSET = Hero.DIMESION - 3 * Stick.WIDTH;
            imageview.setY(imageview.getY() + (FLIP_Y_OFFSET) * cur_state);
            is_down = !is_down;
        }
    }

    public void fall(Runnable onFinished) {
        falling_animation.setOnFinished(event -> {
            if (onFinished != null) {
                onFinished.run(); // Execute the next instruction
            }
        });
        falling_animation.play();
    }
}
