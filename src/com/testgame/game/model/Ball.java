package com.testgame.game.model;

import com.testgame.framework.util.RandomNumberGenerator;
import com.testgame.game.main.GameMain;
import com.testgame.game.main.Resources;

import java.awt.*;

/**
 * Created by Hollow on 01.11.14.
 */
public class Ball {
    private int x, y, width, height, velX, velY;
    private Rectangle rectangle;

    public Ball(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velX = 5;
        this.velY = RandomNumberGenerator.getRandomIntBetween(-4,5);
        this.rectangle = new Rectangle(x,y,width,height);
    }

    public void update() {
        x += velX;
        y += velY;
        correctYCollisions();
        updateRectangle();
    }

    private void updateRectangle() {
        if (y < 0) {
            y = 0;
        } else if (y + height > GameMain.GAME_HEIGHT) {
            y = GameMain.GAME_HEIGHT - height;
        } else {
            return;
        }
        velY = -velY;
        Resources.bounce.play();
    }

    private void correctYCollisions() {
        rectangle.setBounds(x, y, width, height);

    }
    public void onCollideWith(Paddle p) {
        if (x < GameMain.GAME_WIDTH / 2) {
            x = p.getX() + p.getWidth();
        } else {
            x = p.getX() - width;
        }
        velX = -velX;
        velY += RandomNumberGenerator.getRandomIntBetween(-2, 3);
    }

    public boolean isDead() {
        return (x < 0 || x + width > GameMain.GAME_WIDTH);
    }


    public void reset() {
        x = 300;
        y = 200;
        velX = 5;
        velY = RandomNumberGenerator.getRandomIntBetween(-4, 5);
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
