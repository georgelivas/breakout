package com.company;

import java.util.List;
import java.util.Observable;

/**
 * Model of the game of breakout
 */

public class Model extends Observable {
    // Boarder
    private static final int B = 6;                 // Border offset
    private static final int M = 40;                // Menu offset

    // Size of things
    private static final float BALL_SIZE = 20;      // Ball side
    private static final float BRICK_WIDTH = 50;    // Brick size
    private static final float BRICK_HEIGHT = 30;

    private static final int BAT_MOVE = 5;          // Distance to move bat

    // Scores
    private static final int HIT_BRICK = 50;        // Score
    private static final int HIT_BOTTOM = -200;     // Score

    private GameObj ball;                           // The ball
    private List<GameObj> bricks;                   // The bricks
    private GameObj bat;                            // The bat

    private boolean runGame = true;                 // Game running
    private boolean fast = false;                   // Sleep in run loop

    private int score = 0;

    private final float W;                          // Width of area
    private final float H;                          // Height of area
    private final int level;
    private int lives = 3;
    private static boolean gameOver = false;

    public Model(int width, int height, int level) {
        this.W = width;
        this.H = height;
        this.level = level;
    }

    /**
     * Create in the model the objects that form the game
     */

    public void createGameObjects() {
        synchronized(Model.class) {
            ball   = new GameObj(W/2, H/2, BALL_SIZE, BALL_SIZE, Colour.SILVER);
            bat    = new GameObj(W/2, H - (BRICK_HEIGHT*1.5f), (BRICK_WIDTH*3)/level,
                    BRICK_HEIGHT/4, Colour.WHITE);
            bricks = level == 1 ? Levels.level1() : Levels.level2();
            // *[1]******************************************************[1]*
            // * Fill in code to place the bricks on the board              *
            // **************************************************************
        }
    }

    private ActivePart active = null;

    /**
     * Start the continuous updates to the game
     */
    public void startGame() {
        synchronized (Model.class) {
            stopGame();
            active = new ActivePart();
            active.setSpeed(level == 1 ? 4 : 5);
            Thread t = new Thread(active::runAsSeparateThread);
            t.setDaemon(true);   // So may die when program exits
            t.start();
        }
    }

    /**
     * Stop the continuous updates to the game
     * Will freeze the game, and let the thread die.
     */
    public void stopGame() {
        synchronized ( Model.class ) {
            if ( active != null ) {
                active.stop();
                active = null;
            }
        }
    }

    public GameObj getBat() {
        return bat;
    }

    public GameObj getBall() {
        return ball;
    }

    public List<GameObj> getBricks() {
        return bricks;
    }

    /**
     * Add to score n units
     * @param n units to add to score
     */
    protected void addToScore(int n) {
        score += n;
    }

    public int getScore() {
        return score;
    }

    public int getLives() {
        return this.lives;
    }

    /**
     * Set speed of ball to be fast (true/ false)
     * @param fast Set to true if require fast moving ball
     */
    public void setFast(boolean fast) {
        this.fast = fast;
    }

    /**
     * Move the bat. (-1) is left or (+1) is right
     * @param direction - The direction to move
     */
    public void moveBat(int direction) {
        // *[2]******************************************************[2]*
        // * Fill in code to prevent the bat being moved off the screen *
        // **************************************************************
        if (level == 2) {
            if (bat.getX() < 500 && direction > 0 || bat.getX() >= 40 && direction < 0) {
                float dist = direction * BAT_MOVE * level;    // Actual distance to move
                Debug.trace("Model: Move bat = %6.2f", dist);
                bat.moveX(dist);
            }
        } else {
            if (bat.getX() < 420 && direction > 0 || bat.getX() > 30 && direction < 0) {
                float dist = direction * BAT_MOVE * level;    // Actual distance to move
                Debug.trace("Model: Move bat = %6.2f", dist);
                bat.moveX(dist);
            }
        }
    }

    /**
     * This method is run in a separate thread
     * Consequence: Potential concurrent access to shared variables in the class
     */
    class ActivePart {
        private boolean runGame = true;
        public void stop() {
            runGame = false;
        }
        public int speed;

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public void runAsSeparateThread() {
            final float S = speed; // Units to move (Speed)
            boolean hitBottom = false;
            try {
                synchronized (Model.class) {        // Make thread safe
                    GameObj ball = getBall();       // Ball in game
                    GameObj bat = getBat();         // Bat
                    List<GameObj> bricks = getBricks();   // Bricks
                }

                while (runGame) {
                    synchronized (Model.class) { // Make thread safe
                        float x = ball.getX();  // Current x,y position
                        float y = ball.getY();
                        // Deal with possible edge of board hit

                        if (x >= W - B - BALL_SIZE) {
                            PlaySound.wallBeep();
                            ball.changeDirectionX();
                        }

                        if (x <= B) {
                            PlaySound.wallBeep();
                            ball.changeDirectionX();
                        }

                        if (y >= H - B - BALL_SIZE - 30) {  // Bottom
                            PlaySound.bottomBeep();
                            ball.changeDirectionY();
                            addToScore(HIT_BOTTOM);
                            lives--;
                            hitBottom = true;
                        }

                        if (y <= M) {
                            PlaySound.wallBeep();
                            ball.changeDirectionY();
                        }

                        boolean hit = false;

                        // *[3]******************************************************[3]*
                        // * Fill in code to check if a visible brick has been hit      *
                        // *      The ball has no effect on an invisible brick          *
                        // **************************************************************

                        for (int i = 0; i < bricks.size(); i++) {
                            if (level == 1) {
                                if (bricks.get(i).hitBy(ball) && bricks.get(i).isVisible()) {
                                    hit = true;
                                    PlaySound.smash();
                                    bricks.get(i).setVisibility(false);
                                    score += HIT_BRICK;
                                }
                            } else {
                                if (bricks.get(i).hitBy(ball) && bricks.get(i).isVisible()) {
                                    hit = true;
                                    if (bricks.get(i).getTimesHit() > 0) {
                                        PlaySound.smash();
                                        bricks.get(i).setVisibility(false);
                                        score += HIT_BRICK;
                                    } else {
                                        PlaySound.smash();
                                        bricks.get(i).increaseTimesHit();
                                        bricks.get(i).setColour(Colour.RED);
                                    }
                                }
                            }
                            int brokenBricks = 0;
                            for (int j = 0; j <bricks.size(); j++) {
                                if (!bricks.get(j).isVisible()) {
                                    brokenBricks++;
                                }
                            }

                            if (brokenBricks == bricks.size()) {
                                gameOver = true;
                                PlaySound.youWin();
                            }
                        }

                        if (hit) {
                            ball.changeDirectionY();
                        }

                        if (ball.hitBy(bat)) {
                            ball.changeDirectionY();
                            PlaySound.bat();
                        }

                        if (lives == 0) {
                            gameOver = true;
                            PlaySound.gameOver();
                        }

                        if (gameOver) {
                            stop();
                        }
                    }
                    if (hitBottom && !gameOver) {
                        try{
                            ball.setVisibility(false);
                            modelChanged();
                            Thread.sleep(1000);
                            ball.setTopX(bat.getX()+(bat.getWidth()/2));
                            ball.setTopY(H/2);
                            modelChanged();
                            Thread.sleep(100);
                            ball.setColour(Colour.RED);
                            modelChanged();
                            Thread.sleep(1000);
                            ball.setVisibility(true);
                            modelChanged();
                            Thread.sleep(100);
                            ball.changeDirectionY();
                            ball.setColour(Colour.SILVER);
                            hitBottom =false;
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }

                    modelChanged(); // Model changed refresh screen
                    Thread.sleep(fast ? 2 : 20);
                    ball.moveX(S);
                    ball.moveY(S);
                }
            } catch (Exception e) {
                Debug.error("Model.runAsSeparateThread - Error\n%s", e.getMessage());
            }
        }
    }

    /**
     * Model has changed so notify observers so that they
     *  can redraw the current state of the game
     */
    public void modelChanged() {
        setChanged();
        notifyObservers();
    }

}
