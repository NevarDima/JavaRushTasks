package com.javarush.task.task13.task1328;

/* 
Битва роботов
*/

import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        Random random = new Random();
        Robot amigo = new Robot("Амиго", 10);
        Robot enemy = new Robot("Сгибальщик-02", 10);

        while(amigo.getHealth()>0 && enemy.getHealth()>0){
            if(random.nextBoolean()){
                doMove(amigo,enemy);
            }else{
                doMove(enemy,amigo);
            }
        }
    }

    public static void doMove(AbstractRobot robotFirst, AbstractRobot robotSecond) {
        BodyPart attacked = robotFirst.attack();
        BodyPart defenced = robotFirst.defense();
        if(!attacked.equals(defenced)){
            robotSecond.setHealth(robotSecond.getHealth()-1);
        }
        System.out.println(String.format("%s атаковал робота %s, атакована %s, защищена %s, жизней у %s: %d",
                robotFirst.getName(), robotSecond.getName(), attacked, defenced, robotSecond.getName(), robotSecond.getHealth()));
        if(robotSecond.getHealth()==0){
            System.out.println(String.format("%s победил робота %s", robotFirst.getName(), robotSecond.getName()));
        }else{
            System.out.println(String.format("%s победил робота %s",  robotSecond.getName(), robotFirst.getName()));
        }
    }
}
