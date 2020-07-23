package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnemyFleet {
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length+1;
    private List<EnemyShip> ships;
    private Direction  direction = Direction.RIGHT;

    public EnemyFleet(){
        createShips();
    }

    private void createShips(){
        ships = new ArrayList<>();
        for (int i = 0; i < ROWS_COUNT; i++) {
            for (int j = 0; j < COLUMNS_COUNT; j++) {
                ships.add(new EnemyShip(j*STEP,i*STEP+12));
            }
        }
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2 - 1, 5));
    }

    public void draw(Game game){
        for (EnemyShip ship : ships) {
            ship.draw(game);
        }
    }

    private double getLeftBorder(){
        double min = SpaceInvadersGame.WIDTH;
        for (EnemyShip ship : ships) {
            if(ship.x<min){
                min = ship.x;
            }
        }
        return min;
    }

    private double getRightBorder(){
        double max = 0;
        for (EnemyShip ship : ships) {
            if(ship.x+ship.width>max){
                max = ship.x+ship.width;
            }
        }
        return max;
    }

    private double getSpeed(){
        return Math.min(2.0, 3.0/ships.size());
    }

    public void move(){
        if(ships.isEmpty()){
            return;
        }

        double speed = getSpeed();

        if(direction == Direction.LEFT && getLeftBorder()<0){
            direction = Direction.RIGHT;
            for (EnemyShip ship : ships) {
                ship.move(Direction.DOWN,speed);
            }
        }else if(direction == Direction.RIGHT && getRightBorder()>SpaceInvadersGame.WIDTH){
            direction = Direction.LEFT;
            for (EnemyShip ship : ships) {
                ship.move(Direction.DOWN,speed);
            }
        }else{
            for (EnemyShip ship : ships) {
                ship.move(direction,speed);
            }
        }
    }

    public Bullet fire(Game game){
        if(ships.isEmpty()){
            return null;
        }else{
            if(game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY)>0){
                return null;
            }
            int shipIndex = game.getRandomNumber(ships.size());
            return ships.get(shipIndex).fire();
        }


    }

    public int verifyHit(List<Bullet> bullets){
        if(bullets.isEmpty()){
            return 0;
        }
        int score = 0;
        for (EnemyShip ship : ships) {
            if(ship.isAlive) {
                for (Bullet bullet : bullets) {
                    if (bullet.isAlive) {
                        if (ship.isCollision(bullet)) {
                            score += ship.score;
                            ship.kill();
                            bullet.kill();
                        }
                    }
                }
            }
        }
        return score;
    }

    public void deleteHiddenShips(){
        ships.removeIf(tempEnemyShip -> !tempEnemyShip.isVisible());
    }

    public double getBottomBorder(){
        double max = 0;
        for (EnemyShip ship : ships) {
            if(max<ship.y+ship.height){
                max = ship.y+ship.height;
            }
        }
        return max;
    }

    public int getShipsCount(){
        return ships.size();
    }
}
