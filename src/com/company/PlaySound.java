package com.company;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

class PlaySound {
    private String smash = "sounds/smash.wav";
    private String bat = "sounds/bat.wav";
    private String wallBeep = "sounds/beep.wav";
    private String bottomBeep = "sounds/bottomBeep.wav";
    private String youWin = "sounds/youWin.wav";
    private String gameOver = "sounds/gameOver.wav";

    public boolean mute = false;

    public void smash() {
        if (!mute) {
            play(smash);
        }
    }

    public void bat() {
        if (!mute) {
            play(bat);
        }
    }

    public void wallBeep() {
        if (!mute) {
            play(wallBeep);
        }
    }

    public void bottomBeep() {
        if (!mute) {
            play(bottomBeep);
        }
    }

    public void youWin() {
        if (!mute) {
            play(youWin);
        }
    }

    public void gameOver() {
        if (!mute) {
            play(gameOver);
        }
    }

    private void play(String sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResource(sound)));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength()/100000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

