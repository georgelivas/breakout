package com.company;

import java.awt.event.KeyEvent;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model aBreakOutModel, View aBreakOutView ) {
        model = aBreakOutModel;
        view = aBreakOutView;
        view.setController(this);
    }

    public void userKeyInteraction(int keyCode ) {
        switch (keyCode) {
            case -KeyEvent.VK_LEFT:        // Left Arrow
                model.moveBat(-5);
                break;
            case -KeyEvent.VK_RIGHT:       // Right arrow
                model.moveBat(+5);
                break;
            case 'a' :                      // Left Arrow
                model.moveBat(-5);
                break;
            case 'd' :                      // Right arrow
                model.moveBat(+5);
                break;
            case 'f' :
                // Very fast ball movement now
                model.setFast(true);
                break;
            case 'n' :
                // Normal speed
                model.setFast(false);
                break;
            case 'v' :
                PlaySound.mute = !PlaySound.mute;
                break;
            case -KeyEvent.VK_UP:
                model.moveMenuItem("up");
                break;
            case -KeyEvent.VK_DOWN:
                model.moveMenuItem("down");
                break;
            case -KeyEvent.VK_ENTER:
                if (this.model.getMenuItem1().getY() == 800/2+5) {
                    this.model.createGameObjects(2);
                } else {
                    this.model.createGameObjects(1);
                }
                this.model.startGame = true;
                this.model.startGame();
            default :
                Debug.trace("Ch typed = %3d [%c]", keyCode, (char) keyCode);
        }
    }
}
