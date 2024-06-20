package com.javafx.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cherry {

    ImageView imageview;
    static final double DIMESION = 20;

    public Cherry(double positionX) {
        double positionY = Engine.STAND_CLIFF_Y + 2 * Stick.WIDTH;
        this.imageview = new ImageView(new Image(getClass().getResourceAsStream("bitmaps/CHERRY.png")));
        this.imageview.setFitHeight(DIMESION);
        this.imageview.setFitWidth(DIMESION);
        this.imageview.setY(positionY);
        this.imageview.setX(positionX);
        Effects.move_up_down(this.imageview, 5).play();
    }

    public Cherry generate_random_cherry(double pillars_gap) {
        double positionX;
        if (pillars_gap < Hero.DIMESION) {
            positionX = -50; // vherry is not shown on screen
            return new Cherry(positionX);
        }
        positionX = Math.random() * (pillars_gap - Cherry.DIMESION) + Engine.STAND_CLIFF_X;
        return new Cherry(positionX);
    }

    public static int get_total_cherry() {
        String filePath = "total_cherry.txt";
        int totalCherry = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            if (line != null && !line.isEmpty()) {
                totalCherry = Integer.parseInt(line.trim());
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return totalCherry;
    }

    public static void set_total_cherry(int total_cherry) {
        String filePath = "total_cherry.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(Integer.toString(total_cherry));
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
