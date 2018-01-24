package com.company;


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;

class PlaySound {
    private static File smash = new File("src/com/company/sounds/smash.wav");
    private static File bat = new File("src/com/company/sounds/bat.wav");
    private static File wallBeep = new File("src/com/company/sounds/beep.wav");
    private static File bottomBeep = new File("src/com/company/sounds/bottomBeep.wav");
    private static File youWin = new File("src/com/company/sounds/youWin.wav");
    private static File gameOver = new File("src/com/company/sounds/gameOver.wav");

    public static void smash() {
        play(smash);

    }

    public static void bat() {
       play(bat);

    }

    public static void wallBeep() {
        play(wallBeep);
    }

    public static void bottomBeep() {
        play(bottomBeep);
    }

    public static void youWin() {
        play(youWin);
    }

    public static void gameOver() {
        play(gameOver);
    }

    private static void play(File sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength()/100000);
        } catch (Exception e) {
        }
    }

}

