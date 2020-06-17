package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private Snake snake;
    private Apple apple;
    private int turnDelay;
    private boolean isGameStopped;
    private static final int GOAL = 28;
    private int score;


    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame(){
        snake = new Snake(WIDTH/2,HEIGHT/2);
        createNewApple();
        isGameStopped = false;
        drawScene();
        turnDelay = 300;
        setTurnTimer(turnDelay);
        score = 0;
        setScore(score);
    }

    private void drawScene(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellValueEx(i,j,Color.DARKSEAGREEN,"");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if(!apple.isAlive){
            score+=5;
            setScore(score);
            turnDelay-=10;
            setTurnTimer(turnDelay);
            createNewApple();
        }
        if(!snake.isAlive){
            gameOver();
        }
        if(snake.getLength()>GOAL){
            win();
        }
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key){
            case LEFT:
                snake.setDirection(Direction.LEFT);
                break;
            case RIGHT:
                snake.setDirection(Direction.RIGHT);
                break;
            case DOWN:
                snake.setDirection(Direction.DOWN);
                break;
            case UP:
                snake.setDirection(Direction.UP);
                break;
            case SPACE:
                if(isGameStopped){
                    createGame();
                }
                break;
        }
    }

    private void createNewApple(){
        Apple apple;
        do {
            int x = getRandomNumber(WIDTH);
            int y = getRandomNumber(HEIGHT);
            apple = new Apple(x, y);
        } while (snake.checkCollision(apple));
        this.apple = apple;

    }

    private void gameOver(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.LIGHTCYAN, "GAME OVER!", Color.BLACK, 75);
    }

    private  void win(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.LIGHTCYAN, "WIN!", Color.BLACK, 75);
    }
}
