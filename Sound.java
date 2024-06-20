package com.javafx.game;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {

    static boolean isMuted = false;

    private static MediaPlayer background;
    private static MediaPlayer stick_grow;
    private static MediaPlayer hero_fall;
    private static MediaPlayer whoosh;
    private static MediaPlayer score;
    private static MediaPlayer perfect_score;
    private static MediaPlayer game_over;
    private static MediaPlayer click;

    public static void background() {
        String audiopath = Sound.class.getResource("sounds/BACKGROUND.wav").toString();
        Media backgroundMusic = new Media(audiopath);
        background = new MediaPlayer(backgroundMusic);
        background.setCycleCount(MediaPlayer.INDEFINITE);
        background.play();
    }

    public static void stick_grow() {
        String audiopath = Sound.class.getResource("sounds/STICK_GROW.mp3").toString();
        Media backgroundMusic = new Media(audiopath);
        stick_grow = new MediaPlayer(backgroundMusic);
        stick_grow.setCycleCount(MediaPlayer.INDEFINITE);
        stick_grow.play();
    }

    public static void stop_stick_grow() {
        stick_grow.stop();
    }

    public static void hero_fall() {
        String audiopath = Sound.class.getResource("sounds/HERO_FALL.mp3").toString();
        Media backgroundMusic = new Media(audiopath);
        hero_fall = new MediaPlayer(backgroundMusic);
        hero_fall.play();
    }

    public static void flip() {
        String audiopath = Sound.class.getResource("sounds/WHOOSH.mp3").toString();
        Media backgroundMusic = new Media(audiopath);
        whoosh = new MediaPlayer(backgroundMusic);
        whoosh.play();
    }

    public static void score() {
        String audiopath = Sound.class.getResource("sounds/SCORE.wav").toString();
        Media backgroundMusic = new Media(audiopath);
        score = new MediaPlayer(backgroundMusic);
        score.play();
    }

    public static void click() {
        String audiopath = Sound.class.getResource("sounds/CLICK.mp3").toString();
        Media backgroundMusic = new Media(audiopath);
        click = new MediaPlayer(backgroundMusic);
        click.play();
    }

    public static void game_over() {
        String audiopath = Sound.class.getResource("sounds/GAMEOVER.mp3").toString();
        Media backgroundMusic = new Media(audiopath);
        game_over = new MediaPlayer(backgroundMusic);
        game_over.play();
    }

    public static void perfect_score() {
        String audiopath = Sound.class.getResource("sounds/PERFECT_SCORE.mp3").toString();
        Media backgroundMusic = new Media(audiopath);
        perfect_score = new MediaPlayer(backgroundMusic);
        perfect_score.play();
    }

    public static void mute() {
        // background.setMute(true);
        // stick_grow.setMute(true);
        // hero_fall.setMute(true);
        // whoosh.setMute(true);
        // score.setMute(true);
        // click.setMute(true);
        isMuted = true;
    }

    public static void unmute() {
        // background.setMute(false);
        // stick_grow.setMute(false);
        // hero_fall.setMute(false);
        // whoosh.setMute(false);
        // score.setMute(false);
        // click.setMute(false);
        isMuted = false;
    }
}
