package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Levels {
    private static float BRICK_WIDTH = 50;    // Brick size
    private static float BRICK_HEIGHT = 30;

    private static Colour[] colors = {Colour.YELLOW, Colour.GREEN, Colour.BLUE, Colour.PURPLE};

    private static Colour pickColor() {
        return colors[new Random().nextInt(colors.length)];
    }

    public static List<GameObj> level1() {
        List<GameObj> bricks = new ArrayList<>();

        IntStream
                .iterate(20, x -> x + 52)
                .limit(11)
                .forEach(x ->
                        IntStream
                                .iterate(50, y -> y + 31)
                                .limit(9)
                                .filter(y ->
                                        !((y == 143 && (x > 72) && (x < 488)) ||
                                        (y == 112 && (x > 72) && (x < 488)) ||
                                        (y == 205 && (x > 72) && (x < 488)) ||
                                        (y == 236 && (x > 72) && (x < 488))))
                                .forEach( y ->
                                        bricks.add(new GameObj(x, y, BRICK_WIDTH, BRICK_HEIGHT, pickColor()))
                                )
        );

        Collections.shuffle(bricks);
        bricks.stream().filter(elm -> !elm.getPowerUp()).limit((long)(3)).forEach(brk -> brk.setPowerUp(true));
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

        Collections.shuffle(bricks);
        bricks.stream().filter(elm -> !elm.getPowerUp()).limit((long)(3)).forEach(brk -> brk.setPowerUp(true));
        return bricks;
    }
}
