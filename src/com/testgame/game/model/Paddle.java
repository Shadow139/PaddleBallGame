package com.testgame.game.model;

import java.awt.*;

/**
 * Created by Hollow on 01.11.14.
 */
public class Paddle {
    private final static int MOVEMENT_SPEED = 5;
    private int x,y,width,height,velY;
    private Rectangle rectangle;

    public Paddle(int height, int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rectangle = new Rectangle(x,y,width,height);
        velY = 0;
    }

    public void update(){
        y += velY;
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
