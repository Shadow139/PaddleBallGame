package com.testgame.game.model;

import com.testgame.game.main.GameMain;

import java.awt.*;

/**
 * Created by Hollow on 01.11.14.
 */
public class Paddle {
    private final static int MOVEMENT_SPEED = 5;
    private int x,y,width,height,velY;
    private Rectangle rectangle;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rectangle = new Rectangle(x,y,width,height);
        velY = 0;
    }

    public void update(){
        y += velY;

        if(y < 0){
            y = 0;
        }else if(y + height > GameMain.GAME_HEIGHT){
                   y = GameMain.GAME_HEIGHT - height;
        }

        updateRectangle();
    }

    private void updateRectangle() {
        rectangle.setBounds(x,y,width,height);
    }

    public void accelUp(){
        velY = -MOVEMENT_SPEED;
    }


    public void accelDown(){
        velY = MOVEMENT_SPEED;
    }

    public void stop(){
        velY = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
