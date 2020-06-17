package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String,Cat> catMap = new HashMap<>();
        catMap.put("cat1",new Cat("cat1"));
        catMap.put("cat2",new Cat("cat2"));
        catMap.put("cat3",new Cat("cat3"));
        catMap.put("cat4",new Cat("cat4"));
        catMap.put("cat5",new Cat("cat5"));
        catMap.put("cat6",new Cat("cat6"));
        catMap.put("cat7",new Cat("cat7"));
        catMap.put("cat8",new Cat("cat8"));
        catMap.put("cat9",new Cat("cat9"));
        catMap.put("cat10",new Cat("cat10"));
        return catMap;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        return new HashSet<>(map.values());
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
