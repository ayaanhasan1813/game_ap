package com.javafx.game;



import javafx.event.ActionEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Objects;

public class SoundManager {
    //design pattern singleton implemented
    private static SoundManager instance;

    private AudioClip clickSound;
    private MediaPlayer starting_screenbackgrndmusic;
    private MediaPlayer running_gamemusic;

    private boolean isMuted = false;

    // Private constructor to prevent instantiation
    private SoundManager() {
        // Initialization code here
    }

    // Public method to get the singleton instance
    public static synchronized SoundManager getInstance() {
        if (instance == null) {
            instance = new SoundManager();
        }
        return instance;
    }

    public void pauseHomeScreenBGM() {
        starting_screenbackgrndmusic.pause();
    }

    public void playGameBGM() {
        if (isMuted) {
            return;
        }
        String musicPath = Objects.requireNonNull(getClass().getResource("sounds/gameMusic.mp3")).toString();
        Media media = new Media(musicPath);
        running_gamemusic = new MediaPlayer(media);
        running_gamemusic.setAutoPlay(true);
        running_gamemusic.setVolume(0.2);
        running_gamemusic.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public void playPlayerFallSound() {
        if (isMuted) {
            return;
        }

        String musicPath = Objects.requireNonNull(getClass().getResource("sounds/playerfall.mp3")).toString();
        Media media = new Media(musicPath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        // Set volume (optional, adjust as needed)
        mediaPlayer.setVolume(1.0);

        // Play the sound
        mediaPlayer.play();

        // Release resources after the sound finishes playing
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.dispose());
    }

    public boolean switchMusic(ActionEvent event) {
        if (isMuted) {
            isMuted = false;
            starting_screenbackgrndmusic.play();
            return true;
        } else {
            isMuted = true;
            starting_screenbackgrndmusic.pause();
            return false;
        }
    }

    public void playClickSound() {
        if (!isMuted) {
            String musicPath = Objects.requireNonNull(getClass().getResource("sounds/click.mp3")).toString();
            clickSound = new AudioClip(musicPath);
            clickSound.play();
        } else {
            return;
        }
    }


    public void playGameOverSound() {
        if (!isMuted) {

            String musicPath = Objects.requireNonNull(getClass().getResource("sounds/gameOver.mp3")).toString();
            clickSound = new AudioClip(musicPath);
            clickSound.play();}
        else {
            return;
        }
    }


    public void playStickGrowSound() {
        if (isMuted) {
            return;
        }

        String musicPath = Objects.requireNonNull(getClass().getResource("sounds/stickgrow.mp3")).toString();
        Media media = new Media(musicPath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        // Set volume (optional, adjust as needed)
        mediaPlayer.setVolume(1.0);

        // Play the sound
        mediaPlayer.play();

        // Release resources after sound finishes playing
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.dispose());
    }


    public void playStickFallSound() {
        if(!isMuted) {
            String musicPath = Objects.requireNonNull(getClass().getResource("sounds/stickfall.mp3")).toString();
            Media media = new Media(musicPath);
            MediaPlayer mediaPlayer = new MediaPlayer(media);

            mediaPlayer.setVolume(1.0);

            mediaPlayer.play();

            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.dispose());}
        else {
            return;
        }
    }

    public void playPlaySound() {
        if (!isMuted) {
            String musicPath = Objects.requireNonNull(getClass().getResource("sounds/play.mp3")).toString();
            clickSound = new AudioClip(musicPath);
            clickSound.play();
        } else {
            return;
        }
    }

    public void playHomeScreenBGM(){
        isMuted = false;
        String musicPath = Objects.requireNonNull(getClass().getResource("sounds/bgm.mp3")).toString();
        Media media = new Media(musicPath);
        starting_screenbackgrndmusic = new MediaPlayer(media);
        starting_screenbackgrndmusic.setAutoPlay(true);
        starting_screenbackgrndmusic.setVolume(0.2);
        starting_screenbackgrndmusic.setCycleCount(MediaPlayer.INDEFINITE);
    }


}


