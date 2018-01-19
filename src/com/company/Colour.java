package com.company;

import java.awt.*;

/**
 * Hide the specific internal representation of colours
 *  from most of the program.
 * Map to Swing color when required.
 */
public enum Colour {
    RED(Color.RED),
    BLUE(Color.BLUE),
    WHITE(Color.WHITE),
    GRAY(Color.GRAY);

    private final Color c;

    Colour( Color c ) {
        this.c = c;
    }

    public Color forSwing() {
        return c;
    }
}


