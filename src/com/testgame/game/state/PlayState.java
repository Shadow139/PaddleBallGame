package com.testgame.game.state;

import com.testgame.game.main.Game;
import com.testgame.game.main.GameMain;
import com.testgame.game.main.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Hollow on 31.10.14.
 */
public class PlayState extends State {
    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Resources.darkBlue);
        g.fillRect(0,0, GameMain.GAME_WIDTH,GameMain.GAME_HEIGHT);
        g.setColor(Resources.darkRed);
        g.fillRect(GameMain.GAME_WIDTH/2, 0, GameMain.GAME_WIDTH/2,GameMain.GAME_HEIGHT);

        g.drawImage(Resources.line,(GameMain.GAME_WIDTH/2)-2,0,null);

    }

    @Override
    public void onClick(MouseEvent e) {

    }

    @Override
    public void onKeyPress(KeyEvent e) {

    }

    @Override
    public void onKeyRelease(KeyEvent e) {

    }
}
