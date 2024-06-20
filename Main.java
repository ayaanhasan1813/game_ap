package com.javafx.game;

import javafx.application.Application;

import javafx.stage.Stage;

public class Main extends Application {

    static final double SCREEN_WIDTH = 400;
    static final double SCREEN_HEIGHT = 750;

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Screen_Loader.primaryStage = primaryStage;
        primaryStage.setTitle("Stick Hero. ");
        Screen_Loader.home();
        Sound.background();
    }
}