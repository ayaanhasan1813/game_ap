package com.javafx.game;

import java.io.*;

public class Score {

    public static int get_best_score() {
        String filePath = "best_score.txt";
        int bestScore = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            if (line != null && !line.isEmpty()) {
                bestScore = Integer.parseInt(line.trim());
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return bestScore;
    }

    public static void set_best_score(int newBestScore) {
        String filePath = "best_score.txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(Integer.toString(newBestScore));
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
