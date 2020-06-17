package com.javarush.task.task06.task0606;

/* 
Чётные и нечётные циферки
*/

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код

        Scanner sc=new Scanner(System.in);
        int num = sc.nextInt();

        while (num!=0){
            if((num%10)%2==0){
                even++;
            }else{
                odd++;
            }
            num/=10;
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
