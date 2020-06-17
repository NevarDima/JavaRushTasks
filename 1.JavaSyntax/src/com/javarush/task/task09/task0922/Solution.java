package com.javarush.task.task09.task0922;

/* 
Какое сегодня число?
*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        String line = sc.nextLine();
        String[] dateArr = new String[3];
        dateArr = line.split("-");
        Calendar calendar = new GregorianCalendar(Integer.parseInt(dateArr[0])
                ,Integer.parseInt(dateArr[1])-1
                , Integer.parseInt(dateArr[2]));
        Date date = calendar.getTime();
        SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
        System.out.println(df.format(date).toUpperCase());
    }
}
