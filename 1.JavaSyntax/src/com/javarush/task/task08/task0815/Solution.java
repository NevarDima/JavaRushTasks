package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new Hashtable<>();
        map.put("Фамилия1", "Дима");
        map.put("Фамилия2", "Андрей");
        map.put("Невар", "Саша");
        map.put("Фамилия3", "Андрей");
        map.put("Иванов", "Дима");
        map.put("Петров", "Андрей");
        map.put("Сидоров", "Дима");
        map.put("Шмаров", "Андрей");
        map.put("Кривов", "Саша");
        map.put("Лохов", "Андрей");
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()){
            if (pair.getValue().equals(name)) {
                count++;
            }
        }
        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()){
            if (pair.getKey().equals(lastName)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        createMap();
    }
}
