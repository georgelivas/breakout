package com.company;


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;

class PlaySound {

    public static void smash() {
        play(new File("/Users/georgelivas/GitHub/breakout_0.1.1/src/com/company/sounds/smash.wav"));

    }

    public static void bat() {
       play(new File("/Users/georgelivas/GitHub/breakout_0.1.1/src/com/company/sounds/bat.wav"));

    }

    public static void wallBeep() {
        play(new File("/Users/georgelivas/GitHub/breakout_0.1.1/src/com/company/sounds/beep.wav"));
    }

    public static void bottomBeep() {
        play(new File("/Users/georgelivas/GitHub/breakout_0.1.1/src/com/company/sounds/bottomBeep.wav"));
    }

    public static void play(File sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength()/100000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

