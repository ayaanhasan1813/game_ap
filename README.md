# Stick Hero Game

Welcome to Stick Hero, a simple JavaFX game where the goal is to extend a stick to reach the next platform. The game is developed by Kanishk and Ayaan.


# note 
"IMPORTANT THING TO DO PLEASE CHANGE THE PATH OF THE HISTORY FILE WHILE RUNNING THE CODE IN YOUR SYSTEM .THE CURRENT PATH IS MY LAPTOPS PATH SO PLEASE CHAGE IT OTHERWISE THERE WILL BE ERROR. YOU HAVE TO CHANGE THE ABSOLUTE  PATH IN LINE 283 AND 309 OF THE MAINGAME CONTROLLER."

# Table of Contents

1.Introduction
2.Game Controls
3.Features
4.Installation
5.How to Play
6.Highscore
7.Dependencies
8.License

# INTRODUCTION
Stick Hero is a game where the player controls a character trying to reach the next platform by extending a stick. The game is built using Java and JavaFX.

# GAME CONTROLS

1.Mouse Press: Extend the stick.
2.Mouse Release: Release the stick and try to reach the next platform.


# FEATURES

1.Dynamic platform generation.
2.Smooth stick extension animation.
3.Character movement to the next platform.
4.Scoring system based on successful platform reach.
5.Game over screen with the option to restart.
6.Highscore tracking.


# Installation
To run the Stick Hero game, ensure you have Java and JavaFX installed on your system. You can run the game by executing the main class com.example.stickheroapplication.HOMEPAGE

# HOW TO PLAY

Click and hold the mouse button to extend the stick.
Release the mouse button to release the stick and try to reach the next platform.
Successfully reaching the next platform increases your score.

If the stick is too short or too long, you will fall and the game will be over.
The game keeps track of your highscore. If you beat your previous highscore, it will be updated automatically.for this we have put the highscore in the hisdtory txt file if you beat your previous highscore it will be displayedon the screen.



# Working
We made three FXML files, representing the Home screen, Gameplay, and game screen. Home Screen consists of functionality in which you can pause the background music and an exit button. We use CSS files to make the code interactive. In the gameplay screen, to extend the stick we use mouse events and then the stick falls just like in the actual game, and for that we use Timeline. The generatePlatform sets the layout value randomly for spawning the platforms randomly and appearing infinitely. And then we are using the method to check the length and compare it with the platform's distances.

# DesignPattern 
We used two Design Patterns named Singleton and flyweight. Singleton Design Pattern is used to manage the SoundManager and flyweight pattern is used in cherry generating process .

# Dependencies
The Stick Hero game uses JavaFX for graphical user interface components. Make sure to have the required JavaFX libraries in your classpath.

# License 
This game is provided under the MIT License. Feel free to use, modify, and distribute the game as per the terms of the license. 

# CONTRIBUTORS
AYAAN HASAN
KANISHK KUMAR MEENA
                                                      




