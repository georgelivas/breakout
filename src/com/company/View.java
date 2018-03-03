package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
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
    private int level;
    private GameObj menuItem1;
    private boolean startGame;
    private boolean youWin;
    private boolean youLose;

    private boolean mute;
    private boolean faster;

    public final int width;   // Size of screen Width
    public final int height;  // Sizeof screen Height

    private BufferedImage muteLogo;
    private BufferedImage volOn;
    private BufferedImage youLoseLogo;
    private BufferedImage youWinLogo;
    private BufferedImage logo;
    private BufferedImage crack;


    public View(int width, int height) {
        this.width = width; this.height = height;
        setSize(width, height);                 // Size of window
        addKeyListener(new Transaction());      // Called when key press
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            muteLogo = ImageIO.read(getClass().getResourceAsStream("/com/company/images/mute.png"));
            volOn = ImageIO.read(getClass().getResourceAsStream("/com/company/images/vol_on.png"));
            youLoseLogo = ImageIO.read(getClass().getResourceAsStream("/com/company/images/you_lose.png"));
            youWinLogo = ImageIO.read(getClass().getResourceAsStream("/com/company/images/you_win.png"));
            logo = ImageIO.read(getClass().getResourceAsStream("/com/company/images/logo.png"));
            crack = ImageIO.read(getClass().getResourceAsStream("/com/company/images/cracked_brick.png"));
        } catch (Exception e){
            Debug.error("can't load images", e);
        }
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

                bricks.stream().filter(GameObj::isVisible).forEach(brk -> displayGameObj(g, brk));
                bricks.stream()
                        .filter(e -> e.getTimesHit() > 0 && level == 2)
                        .filter(GameObj::isVisible)
                        .forEach(brk -> g.drawImage(crack, (int)brk.getX(), (int)brk.getY(), this)
                        );

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

                g.drawImage(mute ? muteLogo : volOn, (width/2)+20, height-28, this);

                if (faster) {
                    g.setPaint(Color.WHITE);
                    g.setFont(font);
                    g.drawString("Faster", 35, 730);
                }

                if (youLose) {
                    g.drawImage(youLoseLogo, 25, 330, this);

                    g.setPaint(Color.WHITE);
                    g.setFont(font);
                    g.drawString("Press ENTER for Menu.", 35, 730);
                }

                if (youWin) {
                    g.drawImage(youWinLogo, 30, 30, this);

                    g.setPaint(Color.WHITE);
                    g.setFont(font);
                    g.drawString("Press ENTER for Menu.", 100, 480);
                }
            } else {        // Display menu
                g.drawImage(logo, 30, 60, this);

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
        ball = model.getBall();                     // Ball
        bricks = model.getBricks();                 // Bricks
        bat = model.getBat();                       // Bat
        score = model.getScore();                    // Score
        lives = model.getLives();
        level = model.getLevel();
        menuItem1 = model.getMenuItem1();
        youWin = model.getYouWin();
        youLose = model.getYouLose();
        startGame = model.startGame;
        mute = model.mute;
        faster = model.faster;
        repaint();                                  // Re draw game
    }

    @Override
    public void update(Graphics g) {                // Called by repaint
        drawPicture((Graphics2D) g);                // Draw Picture
    }


    @Override
    public void paint(Graphics g) {                 // When 'Window' is first
        drawPicture((Graphics2D) g);                // Draw Picture
    }

    private BufferedImage theAI;                    // Alternate Image
    private Graphics2D theAG;                       // Alternate Graphics

    private void drawPicture( Graphics2D g ) {      // Double buffer
                                                    // to avoid flicker
        if (bricks == null) {
            return;
            // Race condition
        }
        if (theAG == null) {
            Dimension d = getSize();                // Size of curr. image
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
        public void keyPressed(KeyEvent e) {           // Obey this method
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
