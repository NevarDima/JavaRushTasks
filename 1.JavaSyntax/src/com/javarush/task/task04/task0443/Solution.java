package com.javarush.task.task04.task0443;

/* 
Как назвали, так назвали
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        Scanner sc=new Scanner(System.in);
        String name = sc.nextLine();
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();

        System.out.println("Меня зовут "+ name + ".");
        System.out.println("Я родился "+year+"."+month+"."+day);

    }
}
