package com.javafx.game;

public class CherryImageFactory {
    private static final String CHERRY_IMAGE_PATH = "images/cherry.png";

    private static CherryPrototype cherryFlyweight;

    public static CherryPrototype getCherryFlyweight() {
        if (cherryFlyweight == null) {
            // Create the flyweight only if it doesn't exist
            cherryFlyweight = new CherryImage(CHERRY_IMAGE_PATH);
        }
        return cherryFlyweight;
    }
}
