package com.javarush.task.task08.task0827;

/* 
Работа с датой
*/

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("JANUARY 2 2020"));
    }

    public static boolean isDateOdd(String date) {
        String[] str = date.split(" ");
        String month = str[0];
        int monthInt = 0;
        int day = Integer.parseInt(str[1]);
        int year = Integer.parseInt(str[2]);
        switch (month){
            case "JANUARY": monthInt = 0;
                break;
            case "FEBRUARY": monthInt = 1;
                break;
            case "MARCH": monthInt = 2;
                break;
            case "APRIL": monthInt = 3;
                break;
            case "MAY": monthInt = 4;
                break;
            case "JUNE": monthInt = 5;
                break;
            case "JULY": monthInt = 6;
                break;
            case "AUGUST": monthInt = 7;
                break;
            case "SEPTEMBER": monthInt = 8;
                break;
            case "OCTOBER": monthInt = 9;
                break;
            case "NOVEMBER": monthInt = 10;
                break;
            case "DECEMBER": monthInt = 11;
                break;
            default: break;
        }
        Calendar calendar = new GregorianCalendar(year,monthInt,day);
        return calendar.get(Calendar.DAY_OF_YEAR)%2!=0;
    }
}
