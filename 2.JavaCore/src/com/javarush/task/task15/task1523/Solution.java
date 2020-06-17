package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {

    String name;
    int num;

    Solution(){
    }

    private Solution(String name){
        this.name = name;
    }

    protected Solution(String name, int num){
        this.name = name;
        this.num = num;
    }

    public Solution(Solution solution){
        this.name = solution.name;
        this.num = solution.num;
    }
}

