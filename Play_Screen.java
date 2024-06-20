package com.javafx.game;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Play_Screen {

    Engine engine;

    @FXML
    Pane pane;

    @FXML
    private ImageView background_imageview;

    @FXML
    private Button pause_button;
    @FXML
    private ImageView pause_button_imageview;
    @FXML
    private ColorAdjust pause_button_coloradjust;

    // all functions for pause button
    @FXML
    private void pause_button_enter() {
        pause_button_coloradjust.setBrightness(-0.2);
    }

    @FXML
    private void pause_button_exit() {
        pause_button_coloradjust.setBrightness(0);
    }

    @FXML
    private void pause_button_click() {
        Sound.click();
        Screen_Loader.pause(engine.score_count);
    }

    // make score counter
    @FXML
    Text score_counter;

    void init_score_count() {
        score_counter.setText(Integer.toString(engine.score_count));
    }

    void gained_score() {
        Sound.score();
        score_counter.setText(Integer.toString(engine.score_count));
        Effects.Bounce(score_counter);
    }

    // make cherry counter
    @FXML
    private ImageView cherry_image_view;
    @FXML
    Text cherry_counter;

    void init_cherry_count() {
        cherry_counter.setText(Integer.toString(engine.cherry_count));
    }

    void gained_cherry() {
        cherry_counter.setText(Integer.toString(engine.cherry_count));
        Effects.Bounce(cherry_image_view);
        Effects.Bounce(cherry_counter);

    }

    @FXML
    void onMousePressed() {
        engine.stick_grow();
        engine.hero_flip();
    }

    @FXML
    void onMouseReleased() {
        engine.try_stop_stick_grow();
    }

    @FXML
    private void initialize() {
        engine = new Engine(this); // composition - play screen contains engine
    }
}
