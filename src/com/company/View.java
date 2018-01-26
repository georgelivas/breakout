package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Displays a graphical view of the game of breakout.
 *  Uses Graphics2D would need to be re-implemented for Android.
 * @author Mike Smith University of Brighton
 */
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


    public final int width;   // Size of screen Width
    public final int height;  // Sizeof screen Height

    /**
     * Construct the view of the game
     * @param width Width of the view pixels
     * @param height Height of the view pixels
     */
    public View(int width, int height) {
        this.width = width; this.height = height;
        setSize(width, height);                 // Size of window
        addKeyListener( new Transaction() );    // Called when key press
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Timer.startTimer();
    }

    /**
     *  Code called to draw the current state of the game
     *   Uses draw:       Draw a shape
     *        fill:       Fill the shape
     *        setPaint:   Colour used
     *        drawString: Write string on display
     *  @param g Graphics context to use
     */
    public void drawActualPicture(Graphics2D g) {
        final int  RESET_AFTER = 200; // Movements
        frames++;
        synchronized(Model.class) { // Make thread safe
            // BLACK background
            g.setPaint(Color.BLACK);
            g.fill(new Rectangle2D.Float( 0, 0, width, height));

            Font font = new Font("Bell MT", Font.BOLD,24);
            g.setFont(font);

            if (startGame) {
                displayBall(g, ball);   // Display the Ball
                displayGameObj(g, bat);   // Display the Bat

                // Display the bricks 4
                for (int i = 0; i < bricks.size(); i++) {
                    if (bricks.get(i).isVisible()) {
                        displayGameObj(g, bricks.get(i));
                    }
                }

                g.setPaint(Color.ORANGE);
                FontMetrics fm = getFontMetrics(font);
                String fmt = "Score: %6d fps=%5.1f";
                String text = String.format(fmt, score,
                        frames / (Timer.timeTaken() / 1000.0)
                );

                if (frames > RESET_AFTER) {
                    frames = 0;
                    Timer.startTimer();
                }
                g.drawString(text, 10, height - 5);

                String lives = "";
                for (int i = 0; i < this.lives; i++) {
                    lives += "♥";
                }

                g.setPaint(Color.RED);
                FontMetrics fm1 = getFontMetrics(font);
                g.drawString(lives, width - 80, height - 5);
            } else {
               // BufferedImage img = new BufferedImage();

                //g.drawImage(img, 300, 400);
                BufferedImage image;
                try {
                    image = ImageIO.read(new File("src/logo.png"));
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
                    go.getHeight() )
        );
    }

    private void displayBall( Graphics2D g, GameObj go ) {
        g.setColor( go.getColour().forSwing() );
        g.fill(
                new Ellipse2D.Float(
                        go.getX(),
                        go.getY(),
                        go.getWidth(),
                        go.getHeight() )
        );
    }

    private void displayLogo() {
        String IMG_PATH = "src/logo.png";
        try {
            BufferedImage img = ImageIO.read(new File(IMG_PATH));
            ImageIcon icon = new ImageIcon(img);
            JLabel label = new JLabel(icon);
            JOptionPane.showMessageDialog(null, label);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update( Observable aModel, Object arg ) {
        Model model = (Model) aModel;
        // Get from the model the ball, bat, bricks & score
        ball = model.getBall();                  // Ball
        bricks = model.getBricks();              // Bricks
        bat = model.getBat();                    // Bat
        score = model.getScore();                // Score
        lives = model.getLives();
        // Debug.trace("Update");
        menuItem1 = model.getMenuItem1();
        startGame = model.startGame;
        repaint();                               // Re draw game
    }

    /**
     * Called by repaint to redraw the Model
     * @param g    Graphics context
     */
    @Override
    public void update(Graphics g) {        // Called by repaint
        drawPicture((Graphics2D) g);        // Draw Picture
    }

    /**
     * Called when window is first shown or damaged
     * @param g    Graphics context
     */
    @Override
    public void paint(Graphics g) {             // When 'Window' is first
                                                // shown or damaged
        drawPicture((Graphics2D) g);            // Draw Picture
    }

    private BufferedImage theAI;              // Alternate Image
    private Graphics2D theAG;                 // Alternate Graphics

    /**
     * Double buffer graphics output to avoid flicker
     * @param g The graphics context
     */
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

    /**
     * Need to be told where the controller is
     * @param aPongController The controller used
     */
    public void setController(Controller aPongController) {
        controller = aPongController;
    }

    /**
     * Methods Called on a key press
     *  calls the controller to process
     */
    private class Transaction implements KeyListener { // When character typed
        @Override
        public void keyPressed(KeyEvent e) {     // Obey this method
            // Make -ve so not confused with normal characters
            controller.userKeyInteraction( -e.getKeyCode() );
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // Called on key release including specials
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // Send internal code for key
            controller.userKeyInteraction( e.getKeyChar() );
        }
    }
}
