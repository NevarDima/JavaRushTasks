package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child1 = new Human("child1", true, 3, new ArrayList<>());
        Human child2 = new Human("child2", false, 6, new ArrayList<>());
        Human child3 = new Human("child3", true, 10, new ArrayList<>());
        Human dad = new Human("dad", true, 45, new ArrayList<>(Arrays.asList(child1,child2,child3)));
        Human mom = new Human("mom", true, 40, new ArrayList<>(Arrays.asList(child1,child2,child3)));
        Human grandpa1 = new Human("grandpa1", true, 76, new ArrayList<>(Collections.singletonList(dad)));
        Human grandma1 = new Human("grandma1", false, 73, new ArrayList<>(Collections.singletonList(dad)));
        Human grandpa2 = new Human("grandpa2", true, 80, new ArrayList<>(Collections.singletonList(mom)));
        Human grandma2 = new Human("grandma2", false, 72, new ArrayList<>(Collections.singletonList(mom)));

        List<Human> people = new ArrayList<>();
        people.add(child1);
        people.add(child2);
        people.add(child3);
        people.add(dad);
        people.add(mom);
        people.add(grandpa1);
        people.add(grandma1);
        people.add(grandpa2);
        people.add(grandma2);

        for (Human human : people){
            System.out.println(human.toString());
        }
    }

    public static class Human {
        //напишите тут ваш код
        public String name;
        public boolean sex;
        public int age;
        List<Human> children;

        public Human(String name, boolean sex, int age, List<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
