package com.javafx.game;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Screen_Loader {

    static Stage primaryStage;

    static void home() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Screen_Loader.class.getResource("fxml/Home_Screen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 750);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void play() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Screen_Loader.class.getResource("fxml/Play_Screen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 750);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void pause(int cur_score_) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Screen_Loader.class.getResource("fxml/Pause_Screen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 750);
            Pause_Screen pause_screen = fxmlLoader.getController();
            pause_screen.custom_init(cur_score_);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void game_over(int cur_score_) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Screen_Loader.class.getResource("fxml/Gameover_Screen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 750);
            Gameover_Screen gameover_screen = fxmlLoader.getController();
            gameover_screen.custom_init(cur_score_);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
