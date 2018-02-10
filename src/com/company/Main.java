package com.company;

public class Main {
    public static final int H = 800; // Height of window
    public static final int W = 600; // Width of window

    public static void main( String args[] ) {
        Debug.trace("BreakOut");
        Debug.set(true);              // Set true to get debug info

        Model model = new Model(W, H);   // model of the Game
        View  view  = new View(W,H);    // View of the Game
        new Controller(model, view);
        model.createGameObjects(1);       // Ball, Bat & Bricks
        model.addObserver(view);       // Add observer to the model

        view.setVisible(true);           // Make visible
        // model.showMenu();
        model.startGame();        // Start playing the game
    }
}
