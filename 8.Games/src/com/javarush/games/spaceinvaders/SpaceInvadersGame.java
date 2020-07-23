package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.Bullet;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.PlayerShip;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private List<Star> stars;
    private EnemyFleet enemyFleet;
    public static final int COMPLEXITY = 5;
    private List<Bullet> enemyBullets;
    private List<Bullet> playerBullets;
    private PlayerShip playerShip;
    private boolean isGameStopped;
    private int animationsCount;
    private static final int PLAYER_BULLETS_MAX = 1;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(WIDTH,HEIGHT);
        createGame();
    }

    private void createGame(){
        createStars();
        enemyFleet = new EnemyFleet();
        enemyBullets = new ArrayList<>();
        playerShip = new PlayerShip();
        isGameStopped = false;
        animationsCount = 0;
        playerBullets = new ArrayList<>();
        score = 0;
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene(){
        drawField();
        enemyFleet.draw(this);
        for (Bullet enemyBullet : enemyBullets) {
            enemyBullet.draw(this);
        }
        for (Bullet playerBullet : playerBullets) {
            playerBullet.draw(this);
        }
        playerShip.draw(this);
    }

    private void drawField(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellValueEx(i,j, Color.BLACK,"");
            }
        }
        for (Star star : stars) {
            star.draw(this);
        }
    }

    private void createStars(){
        stars = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            stars.add(new Star(this.getRandomNumber(WIDTH), this.getRandomNumber(HEIGHT)));
        }
    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        check();
        Bullet newBullet = enemyFleet.fire(this);
        if(newBullet != null){
            enemyBullets.add(newBullet);
        }
        setScore(score);
        drawScene();
    }

    private void moveSpaceObjects(){
        enemyFleet.move();
        for (Bullet enemyBullet : enemyBullets) {
            enemyBullet.move();
        }
        for (Bullet playerBullet : playerBullets) {
            playerBullet.move();
        }
        playerShip.move();
    }

    private void removeDeadBullets(){
        enemyBullets.removeIf(tempBullet -> !tempBullet.isAlive || tempBullet.y >= HEIGHT - 1);
        playerBullets.removeIf(tempBullet -> !tempBullet.isAlive || tempBullet.y + tempBullet.height < 0);
    }

    private void check(){
        playerShip.verifyHit(enemyBullets);
        score += enemyFleet.verifyHit(playerBullets);
        enemyFleet.deleteHiddenShips();
        removeDeadBullets();
        if(!playerShip.isAlive){
            stopGameWithDelay();
        }
        if(enemyFleet.getBottomBorder() >= playerShip.y){
            playerShip.kill();
        }
        if(enemyFleet.getShipsCount() == 0){
            playerShip.win();
            stopGameWithDelay();
        }
    }

    private void stopGame(boolean isWin){
        isGameStopped = true;
        stopTurnTimer();
        if(isWin){
            showMessageDialog(Color.WHITE,"WIN",Color.GREEN,70);
        }else{
            showMessageDialog(Color.WHITE,"LOSE",Color.RED,70);
        }
    }

    private void stopGameWithDelay(){
        animationsCount++;
        if(animationsCount>=10){
            stopGame(playerShip.isAlive);
        }
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key){
            case SPACE:
                if(isGameStopped){
                    createGame();
                }else{
                    Bullet playerBullet = playerShip.fire();
                    if(playerBullet != null && playerBullets.size()<PLAYER_BULLETS_MAX){
                        playerBullets.add(playerBullet);
                    }
                }
                break;
            case LEFT:
                playerShip.setDirection(Direction.LEFT);
                break;
            case RIGHT:
                playerShip.setDirection(Direction.RIGHT);
                break;
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if((key == Key.LEFT && playerShip.getDirection() == Direction.LEFT) ||
                (key == Key.RIGHT && playerShip.getDirection() == Direction.RIGHT)){
            playerShip.setDirection(Direction.UP);
        }
    }

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        if(x>=0 && y>=0 && x<WIDTH &&y<HEIGHT){
            super.setCellValueEx(x, y, cellColor, value);
        }
    }
}
