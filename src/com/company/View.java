package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class View extends JFrame implements Observer {
    private Controller controller;
    private GameObj bat;              // The bat
    private GameObj ball;             // The ball
    private List<GameObj> bricks;     // The bricks
    private int score =  0;           // The score
    private int frames = 0;           // Frames output
    private int lives = 0;
    private GameObj menuItem1;
    private boolean startGame;
    private boolean youWin;
    private boolean youLose;

    public final int width;   // Size of screen Width
    public final int height;  // Sizeof screen Height

    public View(int width, int height) {
        this.width = width; this.height = height;
        setSize(width, height);                 // Size of window
        addKeyListener( new Transaction() );    // Called when key press
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Timer.startTimer();
    }

    public void drawActualPicture(Graphics2D g) {
        frames++;
        synchronized(Model.class) {
            // BLACK background
            g.setPaint(Color.BLACK);
            g.fill(new Rectangle2D.Float( 0, 0, width, height));

            Font font = new Font("Bell MT", Font.BOLD,24);
            g.setFont(font);

            if (startGame) {
                displayBall(g, ball);
                displayGameObj(g, bat);
                
                // Display bricks
                for (GameObj brick : bricks){
                    if (brick.isVisible()) {
                        displayGameObj(g, brick);
                    }
                }

                g.setPaint(Color.ORANGE);
                FontMetrics fm = getFontMetrics(font);
                String fmt = "Score: %6d fps=%5.1f";
                String text = String.format(fmt, score,
                        frames / (Timer.timeTaken() / 1000.0)
                );

                frames = 0;
                Timer.startTimer();

                g.drawString(text, 10, height - 5);

                String lives = "";
                for (int i = 0; i < this.lives; i++) {
                    lives += "♥";
                }
                g.setPaint(Color.RED);
                FontMetrics fm1 = getFontMetrics(font);
                g.drawString(lives, width - 80, height - 5);

                g.setPaint(Color.GRAY);
                FontMetrics fm2 = getFontMetrics(font);
                Font smallFont = new Font("Bell MT", Font.BOLD,11);
                g.setFont(smallFont);
                g.drawString("\'v\' to change vol.", (width/2)+46, height - 12);

                if (PlaySound.mute) {
                    BufferedImage image;
                    try {
                        image = ImageIO.read(new File("src/com/company/images/mute.png"));
                        g.drawImage(image, (width/2)+20, height-28, this);
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                } else {
                    BufferedImage image;
                    try {
                        image = ImageIO.read(new File("src/com/company/images/vol_on.png"));
                        g.drawImage(image, (width/2)+20, height-28, this);
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }

                if (youLose) {
                    BufferedImage image;
                    try {
                        image = ImageIO.read(new File("src/com/company/images/you_lose.png"));
                        g.drawImage(image, 25, 330, this);

                        g.setPaint(Color.WHITE);
                        g.setFont(font);
                        g.drawString("Press ENTER for Menu.", 35, 730);
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }

                if (youWin) {
                    BufferedImage image;
                    try {
                        image = ImageIO.read(new File("src/com/company/images/you_win.png"));
                        g.drawImage(image, 30, 30, this);

                        g.setPaint(Color.WHITE);
                        g.setFont(font);
                        g.drawString("Press ENTER for Menu.", 100, 480);
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            } else {        // Display menu
                BufferedImage image;
                try {
                    image = ImageIO.read(new File("src/com/company/images/logo.png"));
                    g.drawImage(image, 30, 60, this);
                } catch (IOException e) {
                    System.out.println(e);
                }

                displayGameObj(g, menuItem1);
                g.setPaint(Color.WHITE);
                FontMetrics fm1 = getFontMetrics(font);
                g.drawString("LEVEL 1", 600/2-60, 800/2-100);
                g.drawString("LEVEL 2", 600/2-60, 800/2+50);

                g.setPaint(Color.GRAY);
                Font smallFont = new Font("Bell MT", Font.BOLD,16);
                g.setFont(smallFont);
                g.drawString("HIT ENTER TO", 20, 800/2+220);

                Color color1 = Color.YELLOW;
                Color color2 = Color.BLUE;

                GradientPaint gp = new GradientPaint(0, 40, color1, 0, 40, color2);
                g.setPaint(gp);
                Font bigFont = new Font("Bell MT", Font.BOLD,200);
                g.setFont(bigFont);
                g.drawString("PLAY!", 0, 800-30);
            }
        }
    }

    private void displayGameObj( Graphics2D g, GameObj go ) {
        g.setColor( go.getColour().forSwing() );
        g.fill(
                new Rectangle2D.Float(
                    go.getX(),
                    go.getY(),
                    go.getWidth(),
                    go.getHeight()
                )
        );
    }

    private void displayBall( Graphics2D g, GameObj go ) {
        g.setColor( go.getColour().forSwing() );
        g.fill(
                new Ellipse2D.Float(
                        go.getX(),
                        go.getY(),
                        go.getWidth(),
                        go.getHeight()
                )
        );
    }

    @Override
    public void update(Observable aModel, Object arg) {
        Model model = (Model) aModel;
        ball = model.getBall();                  // Ball
        bricks = model.getBricks();              // Bricks
        bat = model.getBat();                    // Bat
        score = model.getScore();                // Score
        lives = model.getLives();
        menuItem1 = model.getMenuItem1();
        youWin = model.getYouWin();
        youLose = model.getYouLose();
        startGame = model.startGame;
        repaint();                               // Re draw game
    }

    @Override
    public void update(Graphics g) {        // Called by repaint
        drawPicture((Graphics2D) g);        // Draw Picture
    }


    @Override
    public void paint(Graphics g) {             // When 'Window' is first
        drawPicture((Graphics2D) g);            // Draw Picture
    }

    private BufferedImage theAI;              // Alternate Image
    private Graphics2D theAG;                 // Alternate Graphics

    private void drawPicture( Graphics2D g ) {      // Double buffer
                                                    // to avoid flicker
        if (bricks == null) return;                 // Race condition
        if (theAG == null) {
            Dimension d = getSize();              // Size of curr. image
            theAI = (BufferedImage) createImage(d.width, d.height);
            theAG = theAI.createGraphics();
        }
        drawActualPicture(theAG);                               //Draw Actual Picture
        g.drawImage(theAI, 0, 0, this );         //Display on screen
    }

    public void setController(Controller aPongController) {
        controller = aPongController;
    }

    private class Transaction implements KeyListener { // When character typed
        @Override
        public void keyPressed(KeyEvent e) {     // Obey this method
            controller.userKeyInteraction(-e.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // Called on key release including specials
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // Send internal code for key
            controller.userKeyInteraction(e.getKeyChar());
        }
    }
}
