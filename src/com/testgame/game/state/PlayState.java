package com.testgame.game.state;

import com.testgame.game.main.Game;
import com.testgame.game.main.GameMain;
import com.testgame.game.main.Resources;
import com.testgame.game.model.Paddle;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Hollow on 31.10.14.
 */
public class PlayState extends State {
    private Paddle paddleLeft,paddleRight;

    private static final int PADDLE_WIDTH = 15;
    private static final int PADDLE_HEIGHT = 60;

    @Override
    public void init() {
        paddleLeft = new Paddle(0,195,PADDLE_WIDTH,PADDLE_HEIGHT);
        paddleRight = new Paddle(785,195,PADDLE_WIDTH,PADDLE_HEIGHT);
    }

    @Override
    public void update() {
        paddleRight.update();
        paddleLeft.update();

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Resources.darkBlue);
        g.fillRect(0,0, GameMain.GAME_WIDTH,GameMain.GAME_HEIGHT);
        g.setColor(Resources.darkRed);
        g.fillRect(GameMain.GAME_WIDTH/2, 0, GameMain.GAME_WIDTH/2,GameMain.GAME_HEIGHT);

        g.drawImage(Resources.line,(GameMain.GAME_WIDTH/2)-2,0,null);

        g.setColor(Color.white);
        g.fillRect(paddleLeft.getX(), paddleLeft.getY(), paddleLeft.getWidth(), paddleLeft.getHeight());
        //System.out.println("paddleLeft: x: " + paddleLeft.getX() + "y: " + paddleLeft.getY()+ "width: " + paddleLeft.getWidth()+ "height: " + paddleLeft.getHeight());
        g.fillRect(paddleRight.getX(), paddleRight.getY(), paddleRight.getWidth(), paddleRight.getHeight());
        //System.out.println("paddleRight: x: " + paddleRight.getX() + "y: " + paddleRight.getY()+ "width: " + paddleRight.getWidth()+ "height: " + paddleRight.getHeight());

    }

    @Override
    public void onClick(MouseEvent e) {
    }

    @Override
    public void onKeyPress(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_UP){
            paddleRight.accelUp();
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            paddleRight.accelDown();
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            paddleLeft.accelUp();
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            paddleLeft.accelDown();
     }
   
    }

    @Override
    public void onKeyRelease(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN){
            paddleRight.stop();
        }
        if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S){
            paddleLeft.stop();
        }

    }
}
