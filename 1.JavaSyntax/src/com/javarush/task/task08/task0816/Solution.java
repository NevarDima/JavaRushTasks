package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне1", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне2", dateFormat.parse("JUNE 1 2012"));
        map.put("Сталлоне3", dateFormat.parse("JULY 1 2012"));
        map.put("Сталлоне4", dateFormat.parse("AUGUST 1 2012"));
        map.put("Сталлоне5", dateFormat.parse("SEPTEMBER 1 2012"));
        map.put("Сталлоне6", dateFormat.parse("OCTOBER 1 2012"));
        map.put("Сталлоне7", dateFormat.parse("NOVEMBER 1 2012"));
        map.put("Сталлоне8", dateFormat.parse("DECEMBER 1 2012"));
        map.put("Сталлоне9", dateFormat.parse("JANUARY 1 2012"));
        map.put("Сталлоне10", dateFormat.parse("FEBRUARY 1 2012"));
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        map.entrySet().removeIf(el -> el.getValue().toString().contains("Jun") || el.getValue().toString().contains("Jul") || el.getValue().toString().contains("Aug"));

    }

    public static void main(String[] args) throws ParseException {
        Map<String,Date> map = createMap();
        removeAllSummerPeople(map);

    }
}
