package com.company;

import java.util.List;
import java.util.Observable;

public class Model extends Observable {
    private static final int B = 6;                 // Border offset
    private static final int M = 40;                // Menu offset

    private static final float BALL_SIZE = 20;      // Ball side
    private static final float BRICK_WIDTH = 50;    // Brick size
    private static final float BRICK_HEIGHT = 30;

    private static final int BAT_MOVE = 5;          // Distance to move bat

    private static final int HIT_BRICK = 50;        // Score
    private static final int HIT_BOTTOM = -200;     // Score

    private GameObj ball;                           // The ball
    private List<GameObj> bricks;                   // The bricks
    private GameObj bat;                            // The bat
    private GameObj menuItem1;
    private PlaySound sound = new PlaySound();

    private boolean fast = false;                   // Sleep in run loop

    private int score = 0;

    private final float W;                          // Width of area
    private final float H;                          // Height of area

    private int level;
    private int lives = 3;
    public boolean startGame = false;
    public static boolean gameOver = false;
    public static boolean mute = false;

    private boolean youWin;
    private boolean youLose;

    public Model(int width, int height) {
        this.W = width;
        this.H = height;
    }

    public void createGameObjects(int level) {
        synchronized(Model.class) {
            this.level = level;
            menuItem1 = new GameObj(W / 2 - 110, H / 2 - 145, 200, 70, Colour.DARK_GREEN);
            ball = new GameObj(W / 2, H / 2, BALL_SIZE, BALL_SIZE, Colour.SILVER);
            bat = new GameObj(W / 2, H - (BRICK_HEIGHT * 1.5f), (BRICK_WIDTH * 3) / level,
                    BRICK_HEIGHT / 4, Colour.WHITE);
            bricks = level == 1 ? Levels.level1() : Levels.level2();

        }
    }

    private ActivePart active = null;

    public void startGame() {
        synchronized (Model.class) {
            stopGame();
            active = new ActivePart();
            active.setSpeed(level == 1 ? 4 : 5);
            Thread t = new Thread(active::runAsSeparateThread);
            t.setDaemon(true);
            t.start();
        }
    }

    public void stopGame() {
        synchronized (Model.class) {
            if (active != null) {
                active.stop();
                active = null;
            }
        }
    }

    public void reset() {
        startGame = false;
        gameOver = false;
        youLose = false;
        youWin = false;
        lives = 3;
        createGameObjects(1);
        startGame();
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

    protected void addToScore(int n) {
        score += n;
    }

    public GameObj getMenuItem1() {
        return menuItem1;
    }

    public int getScore() {
        return score;
    }

    public int getLives() {
        return this.lives;
    }

    public void setFast(boolean fast) {
        this.fast = fast;
    }

    public boolean getYouWin() {
        return youWin;
    }

    public boolean getYouLose() {
        return youLose;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void moveBat(int direction) {
        if (level == 2) {
            if (bat.getX() <= 500 && direction > 0 || bat.getX() >= 40 && direction < 0) {
                float dist = direction * BAT_MOVE * level;    // Actual distance to move
                Debug.trace("Model: Move bat = %6.2f", dist);
                System.out.println(bat.getX());
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

    public void moveMenuItem(String direction) {
        menuItem1.setTopY(direction.equals("up") ? H/2-145 : H/2+5);
    }

    class ActivePart {
        private boolean runGame = true;
        public void stop() {
            runGame = false;
        }
        private int speed;

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

                        sound.mute = mute;

                        if (x >= W - B - BALL_SIZE) {
                            sound.wallBeep();
                            ball.changeDirectionX();
                        }

                        if (x <= B) {
                            sound.wallBeep();
                            ball.changeDirectionX();
                        }

                        if (y >= H - B - BALL_SIZE - 30) {  // Bottom
                            sound.bottomBeep();
                            ball.changeDirectionY();
                            addToScore(HIT_BOTTOM);
                            lives--;
                            hitBottom = true;
                        }

                        if (y <= M) {
                            sound.wallBeep();
                            ball.changeDirectionY();
                        }

                        boolean hit = false;

                        for (int i = 0; i < bricks.size(); i++) {
                            if (level == 1) {
                                if (bricks.get(i).hitBy(ball) && bricks.get(i).isVisible()) {
                                    hit = true;
                                    sound.smash();
                                    bricks.get(i).setVisibility(false);
                                    score += HIT_BRICK;
                                }
                            } else {
                                if (bricks.get(i).hitBy(ball) && bricks.get(i).isVisible()) {
                                    hit = true;
                                    if (bricks.get(i).getTimesHit() > 0) {
                                        sound.smash();
                                        bricks.get(i).setVisibility(false);
                                        score += HIT_BRICK;
                                    } else {
                                        sound.smash();
                                        bricks.get(i).increaseTimesHit();
                                        bricks.get(i).setColour(Colour.RED);
                                    }
                                }
                            }
                            int brokenBricks = 0;
                            for (int j = 0; j < bricks.size(); j++) {
                                if (!bricks.get(j).isVisible()) {
                                    brokenBricks++;
                                }
                            }

                            if (brokenBricks == bricks.size()) {
                                gameOver = true;
                                youWin = true;
                                sound.youWin();
                            }
                        }

                        if (hit) {
                            ball.changeDirectionY();
                        }

                        if (ball.hitBy(bat)) {
                            ball.changeDirectionY();
                            sound.bat();
                        }

                        if (score < 1500) {
                            this.setSpeed(5);
                        }

                        if (lives == 0) {
                            gameOver = true;
                            youLose = true;
                            sound.gameOver();
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
                    if (startGame) {
                        Thread.sleep(fast ? 2 : 20);
                        ball.moveX(S);
                        ball.moveY(S);
                    }
                }
            } catch (Exception e) {
                Debug.error("Model.runAsSeparateThread - Error\n%s", e.getMessage());
            }
        }
    }

    public void modelChanged() {
        setChanged();
        notifyObservers();
    }

}
