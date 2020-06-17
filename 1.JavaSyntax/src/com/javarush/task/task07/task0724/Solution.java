package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human grandDad1 = new Human("grandDad1", true,77);
        Human grandDad2 = new Human("grandDad2", true,87);
        Human grandMom1 = new Human("grandMom1", false,67);
        Human grandMom2 = new Human("grandMom2", false,76);
        Human dad = new Human("dad", true,45, grandDad1, grandMom1);
        Human mom = new Human("mom", false,40, grandDad2, grandMom2);
        Human child1 = new Human("child1", true,15, dad, mom);
        Human child2 = new Human("child2", false,10, dad, mom);
        Human child3 = new Human("child3", true,5, dad, mom);

        System.out.println(grandDad1.toString());
        System.out.println(grandDad2.toString());
        System.out.println(grandMom1.toString());
        System.out.println(grandMom2.toString());
        System.out.println(dad.toString());
        System.out.println(mom.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());
    }

    public static class Human {
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}