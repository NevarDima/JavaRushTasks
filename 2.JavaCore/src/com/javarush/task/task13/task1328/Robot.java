package com.javarush.task.task13.task1328;

public class Robot extends AbstractRobot {
    private String name;
    private int health;

    public Robot(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }
}
