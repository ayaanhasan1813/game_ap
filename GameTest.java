package com.javafx.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testGenerateRandomReachPillar() {

        // Define the minimum and maximum values for width and positionX
        double MIN_WIDTH = 16;
        double MAX_WIDTH = 100;
        double MIN_POSITION_X = Engine.STAND_CLIFF_X + 5;
        double MAX_POSITION_X = Main.SCREEN_WIDTH - MAX_WIDTH;

        // Generate a random reach pillar
        Pillar randomPillar = Pillar.generate_random_reach_pillar();

        // Check if the generated pillar's width is within the valid range
        assertTrue(randomPillar.pillar.getWidth() >= MIN_WIDTH && randomPillar.pillar.getWidth() <= MAX_WIDTH);

        // Check if the generated pillar's X position is within the valid range
        assertTrue(randomPillar.pillar.getX() >= MIN_POSITION_X && randomPillar.pillar.getX() <= MAX_POSITION_X);

        // Ensure the red platform is properly positioned within the pillar
        double redPlatformX = randomPillar.red_platform.getX();
        double redPlatformY = randomPillar.red_platform.getY();
        double redPlatformWidth = randomPillar.red_platform.getWidth();
        double redPlatformHeight = randomPillar.red_platform.getHeight();

        // Check if the red platform is properly positioned horizontally within the
        // pillar
        assertTrue(redPlatformX >= randomPillar.pillar.getX() &&
                redPlatformX + redPlatformWidth <= randomPillar.pillar.getX() + randomPillar.pillar.getWidth());

        // Check if the red platform is properly positioned vertically at the top of the
        // pillar
        assertEquals(Engine.STAND_CLIFF_Y, redPlatformY);

        // Check if the red platform has the specified dimensions
        assertEquals(Pillar.RED_PLATFORM_WIDTH, redPlatformWidth);
        assertEquals(Pillar.RED_PLATFORM_HEIGHT, redPlatformHeight);
    }

}
