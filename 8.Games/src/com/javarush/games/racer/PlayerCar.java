package com.javarush.games.racer;

import com.javarush.games.racer.road.RoadManager;

public class PlayerCar extends GameObject {
    private static int playerCarHeight = ShapeMatrix.PLAYER.length;
    public int speed = 1;
    private Direction direction;

    public PlayerCar() {
        super(RacerGame.WIDTH/2 + 2, RacerGame.HEIGHT - playerCarHeight - 1, ShapeMatrix.PLAYER);
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    public Direction getDirection(){
        return direction;
    }

    public void move(){
        if(direction == Direction.LEFT){
            this.x--;
        }else if(direction == Direction.RIGHT){
            this.x++;
        }
        if(this.x < RoadManager.LEFT_BORDER){
            this.x = RoadManager.LEFT_BORDER;
        }
        if(this.x > RoadManager.RIGHT_BORDER - width){
            this.x = RoadManager.RIGHT_BORDER - width;
        }
    }

    public void stop(){
        this.matrix = ShapeMatrix.PLAYER_DEAD;
    }
}
