package com.company;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math.*;

public class Levels {
    private static float BRICK_WIDTH = 50;    // Brick size
    private static float BRICK_HEIGHT = 30;

    private static Colour[] colors = {Colour.YELLOW, Colour.GREEN, Colour.BLUE, Colour.PURPLE};

    public static void pickColor() {
        System.out.println(Math.random());
    }
    
    public static List<GameObj> level1() {
        pickColor();
        List<GameObj> bricks = new ArrayList<>();
        int dist = 50;
        // first 2 columns
        bricks.add(new GameObj(20, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(20, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(20, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(20, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist +=31;
        bricks.add(new GameObj(20, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(20, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(20, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(20, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(20, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));

        dist = 50; // reset dist

        bricks.add(new GameObj(72, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(72, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(72, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(72, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(72, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist +=31;
        bricks.add(new GameObj(72, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(72, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(72, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(72, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));

        // first 2 rows
        dist = 124;

        bricks.add(new GameObj(dist, 50, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist += 52;
        bricks.add(new GameObj(dist, 50, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist += 52;
        bricks.add(new GameObj(dist, 50, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist += 52;
        bricks.add(new GameObj(dist, 50, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist += 52;
        bricks.add(new GameObj(dist, 50, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist += 52;
        bricks.add(new GameObj(dist, 50, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist += 52;
        bricks.add(new GameObj(dist, 50, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));

        dist = 124;

        bricks.add(new GameObj(dist, 81, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist += 52;
        bricks.add(new GameObj(dist, 81, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist += 52;
        bricks.add(new GameObj(dist, 81, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist += 52;
        bricks.add(new GameObj(dist, 81, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist += 52;
        bricks.add(new GameObj(dist, 81, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist += 52;
        bricks.add(new GameObj(dist, 81, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist += 52;
        bricks.add(new GameObj(dist, 81, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));


        // last 2 columns
        dist = 50; // reset dist

        bricks.add(new GameObj(488, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(488, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(488, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(488, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist +=31;
        bricks.add(new GameObj(488, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(488, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(488, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(488, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(488, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));

        dist = 50; // reset dist

        bricks.add(new GameObj(540, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(540, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(540, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(540, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(540, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist +=31;
        bricks.add(new GameObj(540, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(540, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(540, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(540, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));

        // middle row
        dist = 124;
        bricks.add(new GameObj(dist, 174, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist += 52;
        bricks.add(new GameObj(dist, 174, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist += 52;
        bricks.add(new GameObj(dist, 174, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist += 52;
        bricks.add(new GameObj(dist, 174, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist += 52;
        bricks.add(new GameObj(dist, 174, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist += 52;
        bricks.add(new GameObj(dist, 174, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist += 52;
        bricks.add(new GameObj(dist, 174, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));



        // last 2 rows
        dist = 124;

        bricks.add(new GameObj(dist, 267, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist += 52;
        bricks.add(new GameObj(dist, 267, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist += 52;
        bricks.add(new GameObj(dist, 267, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist += 52;
        bricks.add(new GameObj(dist, 267, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist += 52;
        bricks.add(new GameObj(dist, 267, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist += 52;
        bricks.add(new GameObj(dist, 267, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist += 52;
        bricks.add(new GameObj(dist, 267, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));

        dist = 124;

        bricks.add(new GameObj(dist, 298, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist += 52;
        bricks.add(new GameObj(dist, 298, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist += 52;
        bricks.add(new GameObj(dist, 298, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist += 52;
        bricks.add(new GameObj(dist, 298, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist += 52;
        bricks.add(new GameObj(dist, 298, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist += 52;
        bricks.add(new GameObj(dist, 298, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist += 52;
        bricks.add(new GameObj(dist, 298, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));

        return bricks;
    }

    public static List<GameObj> level2() {
        List<GameObj> bricks = new ArrayList<>();
        int dist = 50;

        // column 1
        bricks.add(new GameObj(20, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.WHITE));
        dist +=31;
        bricks.add(new GameObj(20, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.WHITE));
        dist +=31;
        bricks.add(new GameObj(20, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(20, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(20, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(20, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(20, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(20, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.WHITE));
        dist +=31;
        bricks.add(new GameObj(20, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.WHITE));

        dist = 50; // reset dist

        // column 2
        bricks.add(new GameObj(72, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.WHITE));
        dist +=31;
        bricks.add(new GameObj(72, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(72, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(72, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(72, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist +=31;
        bricks.add(new GameObj(72, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(72, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(72, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(72, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.WHITE));

        dist = 50; // reset dist

        // column 3
        bricks.add(new GameObj(124, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(124, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(124, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(124, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        // empty
        dist +=31;
        dist +=31;
        bricks.add(new GameObj(124, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist +=31;
        bricks.add(new GameObj(124, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(124, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(124, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));

        dist = 50; // reset dist

        // column 4
        bricks.add(new GameObj(176, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(176, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(176, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist +=31;
        // empty
        dist +=31;
        bricks.add(new GameObj(176, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.ORANGE));
        dist +=31;
        // empty
        dist +=31;
        bricks.add(new GameObj(176, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist +=31;
        bricks.add(new GameObj(176, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(176, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));

        dist = 50; // reset dist

        // column 5
        bricks.add(new GameObj(228, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(228, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist +=31;
        // empty
        dist +=31;
        bricks.add(new GameObj(228, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.ORANGE));
        dist +=31;
        bricks.add(new GameObj(228, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.ORANGE));
        dist +=31;
        bricks.add(new GameObj(228, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.ORANGE));
        dist +=31;
        // empty
        dist +=31;
        bricks.add(new GameObj(228, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist +=31;
        bricks.add(new GameObj(228, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));

        dist = 50; // reset dist

        // column 6
        bricks.add(new GameObj(280, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist +=31;
        // empty
        dist +=31;
        bricks.add(new GameObj(280, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.ORANGE));
        dist +=31;
        bricks.add(new GameObj(280, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.ORANGE));
        dist +=31;
        bricks.add(new GameObj(280, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.ORANGE));
        dist +=31;
        bricks.add(new GameObj(280, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.ORANGE));
        dist +=31;
        bricks.add(new GameObj(280, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.ORANGE));
        dist +=31;
        // empty
        dist +=31;
        bricks.add(new GameObj(280, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));

        dist = 50; // reset dist

        // column 7
        bricks.add(new GameObj(332, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(332, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist +=31;
        // empty
        dist +=31;
        bricks.add(new GameObj(332, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.ORANGE));
        dist +=31;
        bricks.add(new GameObj(332, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.ORANGE));
        dist +=31;
        bricks.add(new GameObj(332, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.ORANGE));
        dist +=31;
        // empty
        dist +=31;
        bricks.add(new GameObj(332, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist +=31;
        bricks.add(new GameObj(332, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));

        dist = 50; // reset dist

        // column 8
        bricks.add(new GameObj(384, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(384, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(384, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist +=31;
        // empty
        dist +=31;
        bricks.add(new GameObj(384, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.ORANGE));
        dist +=31;
        // empty
        dist +=31;
        bricks.add(new GameObj(384, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist +=31;
        bricks.add(new GameObj(384, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(384, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));

        dist = 50; // reset dist

        // column 9
        bricks.add(new GameObj(436, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(436, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(436, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(436, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        // empty
        dist +=31;
        dist +=31;
        bricks.add(new GameObj(436, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist +=31;
        bricks.add(new GameObj(436, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(436, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(436, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));

        dist = 50; // reset dist

        // column 10
        bricks.add(new GameObj(488, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.WHITE));
        dist +=31;
        bricks.add(new GameObj(488, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(488, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(488, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(488, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.PURPLE));
        dist +=31;
        bricks.add(new GameObj(488, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(488, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(488, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(488, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.WHITE));

        dist = 50; // reset dist

        // column 11
        bricks.add(new GameObj(540, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.WHITE));
        dist +=31;
        bricks.add(new GameObj(540, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.WHITE));
        dist +=31;
        bricks.add(new GameObj(540, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(540, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(540, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.BLUE));
        dist +=31;
        bricks.add(new GameObj(540, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.GREEN));
        dist +=31;
        bricks.add(new GameObj(540, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.YELLOW));
        dist +=31;
        bricks.add(new GameObj(540, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.WHITE));
        dist +=31;
        bricks.add(new GameObj(540, dist, BRICK_WIDTH, BRICK_HEIGHT, Colour.WHITE));


        return bricks;
    }

}
