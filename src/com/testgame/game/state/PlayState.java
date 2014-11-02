package com.testgame.game.state;

import com.testgame.game.main.Game;
import com.testgame.game.main.GameMain;
import com.testgame.game.main.Resources;
import com.testgame.game.model.Ball;
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

    private Ball ball;
    private static  final int BALL_SIZE = 20;

    private int playerScore = 0;
    private Font scoreFont;

    @Override
    public void init() {
        paddleLeft = new Paddle(0,195,PADDLE_WIDTH,PADDLE_HEIGHT);
        paddleRight = new Paddle(785,195,PADDLE_WIDTH,PADDLE_HEIGHT);

        ball = new Ball(300,200,BALL_SIZE,BALL_SIZE);

        scoreFont = new Font("SansSerif",Font.BOLD,25);
    }

    @Override
    public void update() {
        paddleRight.update();
        paddleLeft.update();
        ball.update();

        if (ballCollides(paddleLeft)) {
            playerScore++;
            ball.onCollideWith(paddleLeft);
            Resources.hit.play();
        } else if (ballCollides(paddleRight)) {
            playerScore++;
            ball.onCollideWith(paddleRight);
            Resources.hit.play();
        } else if (ball.isDead()) {
            playerScore -= 3;
            ball.reset();
        }

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

        g.drawRect(ball.getX(),ball.getY(),ball.getWidth(),ball.getHeight());

        g.setFont(scoreFont);
        g.drawString("" + playerScore,350,40);
    }

    private boolean ballCollides(Paddle p) {
        return ball.getRectangle().intersects(p.getRectangle());
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
