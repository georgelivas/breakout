package com.company;

import java.awt.*;

/**
 * Hide the specific internal representation of colours
 *  from most of the program.
 * Map to Swing color when required.
 */
public enum Colour {
    YELLOW(Color.decode("#FBCB2F")),
    GREEN(Color.decode("#20CE28")),
    DARK_GREEN(Color.decode("#289934")),
    RED(Color.decode("#F00F1A")),
    BLUE(Color.decode("#1C99F9")),
    PURPLE(Color.decode("#9E3EFA")),
    ORANGE(Color.decode("#FBBA38")),
    SILVER(Color.decode("#C0C0C0")),
    BLACK(Color.black),
    WHITE(Color.WHITE),
    GRAY(Color.GRAY);

    private final Color c;

    Colour(Color c) {
        this.c = c;
    }

    public Color forSwing() {
        return c;
    }
}


