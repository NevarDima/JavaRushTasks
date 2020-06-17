package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<>();
        map.put("Фамилия1", 100);
        map.put("Фамилия2", 200);
        map.put("Фамилия3", 300);
        map.put("Фамилия4", 400);
        map.put("Фамилия5", 500);
        map.put("Фамилия6", 600);
        map.put("Фамилия7", 700);
        map.put("Фамилия8", 800);
        map.put("Фамилия9", 900);
        map.put("Фамилия10", 1000);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        Map<String, Integer> copy = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair : copy.entrySet()){
            if(pair.getValue()<500){
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Map<String,Integer> map = createMap();
        removeItemFromMap(map);
    }
}