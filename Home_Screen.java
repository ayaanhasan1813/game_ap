package com.javafx.game;

import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.fxml.FXML;

public class Home_Screen {

    @FXML
    private Pane scene_pane;
    @FXML
    private Button play_button;
    @FXML
    private ImageView play_button_imageview;
    @FXML
    private ColorAdjust play_button_coloradjust;

    @FXML
    private void play_button_enter() {
        play_button_coloradjust.setBrightness(0.1);
    }

    @FXML
    private void play_button_exit() {
        play_button_coloradjust.setBrightness(0);
    }

    @FXML
    private void play_button_click() {
        Sound.click();
        Screen_Loader.play();
    }

    @FXML
    Button load_button;

    @FXML
    ImageView load_button_imageview;

    @FXML
    ColorAdjust load_button_coloradjust;

    @FXML
    private void load_button_enter() {
        load_button_coloradjust.setBrightness(0.3);
    }

    @FXML
    private void load_button_exit() {
        load_button_coloradjust.setBrightness(0);
    }

    @FXML
    private void load_button_click() {
        Sound.click();
        System.err.println("Load button clicked");
    }

    @FXML
    Button volume_button;

    @FXML
    ImageView volume_button_imageview;

    @FXML
    ColorAdjust volume_button_coloradjust;

    @FXML
    private void volume_button_enter() {
        volume_button_coloradjust.setBrightness(0.3);
    }

    @FXML
    private void volume_button_exit() {
        volume_button_coloradjust.setBrightness(0);
    }

    @FXML
    private void volume_button_click() {
        Sound.click();
        System.err.println("Volume button clicked");
        if (Sound.isMuted) {
            Sound.unmute();
            volume_button_imageview
                    .setImage(new Image(getClass().getResource("buttons/VOLUME_ON.png").toExternalForm()));
        } else {
            Sound.mute();
            volume_button_imageview
                    .setImage(new Image(getClass().getResource("buttons/VOLUME_OFF.png").toExternalForm()));
        }
    }

    private void play_button_animate() {// Creating a TranslateTransition for thebutton
        Effects.move_up_down(play_button, 20).play();
    }

    @FXML
    private ImageView idle_hero_imageview;

    private void idle_hero_animate() {
        Effects.animation(idle_hero_imageview, "Idle").play();
    }

    @FXML
    private void initialize() {
        play_button_animate();
        idle_hero_animate();
    }
}