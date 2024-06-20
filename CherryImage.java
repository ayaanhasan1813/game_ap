package com.javafx.game;

import javafx.scene.image.Image;

public class CherryImage implements CherryPrototype {
    private Image image;

    public CherryImage(String imagePath) {
        // Load the image (you can modify this based on your project structure)
        this.image = new Image(imagePath);
    }

    @Override
    public Image getImage() {
        return image;
    }
}
