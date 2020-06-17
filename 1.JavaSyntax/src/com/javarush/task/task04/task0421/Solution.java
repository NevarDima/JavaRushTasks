package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        Scanner sc=new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        if(line1.equals(line2)){
            System.out.println("Имена идентичны");
        }else if(line1.length() == line2.length()){
            System.out.println("Длины имен равны");
        }

    }
}
