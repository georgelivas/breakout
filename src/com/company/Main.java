package com.company;

import java.util.Scanner;

public class Main {
    public static final int H = 800; // Height of window
    public static final int W = 600; // Width of window

    public static void main( String args[] ) {
//        System.out.println("input level");
//        Scanner sc = new Scanner(System.in);
//        int level = sc.nextInt();
//        play(level);

        Debug.trace("BreakOut");
        Debug.set( true );              // Set true to get debug info

        Model model = new Model(W, H);   // model of the Game
        View  view  = new View(W,H);    // View of the Game
        new Controller( model, view );
        model.createGameObjects();       // Ball, Bat & Bricks
        model.addObserver(view);       // Add observer to the model

        view.setVisible(true);           // Make visible
        // model.showMenu();
        model.startGame();        // Start playing the game
    }
}
