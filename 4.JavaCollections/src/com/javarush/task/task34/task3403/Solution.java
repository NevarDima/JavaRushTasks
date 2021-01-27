package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {
    public void recurse(int n) {
        int currentValue = n;
        int multiplier = 2;
        while (multiplier <= currentValue) {
            if (currentValue % multiplier == 0) {
                System.out.print(multiplier + " ");
                if (multiplier == currentValue){return;}
                recurse(currentValue / multiplier);
                break;
            }
            multiplier++;
        }
    }
}
