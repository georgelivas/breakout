package com.company;

import java.util.ArrayList;
import java.util.List;

public class Levels {
    private static float BRICK_WIDTH = 50;    // Brick size
    private static float BRICK_HEIGHT = 30;
    
    public static List<GameObj> level1() {
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
}
