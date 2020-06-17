package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String firstName;
        private String lastName;
        private int age;
        private int height;
        private int weight;
        private boolean sex;

        public Human(String firstName, String lastName, int age, int height, int weight, boolean sex){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.sex = sex;
        }

        public Human(String firstName, String lastName, int age, int height, int weight){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        public Human(String firstName, String lastName, int age, int height){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.height = height;
        }

        public Human(String firstName, String lastName, int age){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Human(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Human(String firstName){
            this.firstName = firstName;
        }

        public Human(){

        }

        public Human(Human human){
            this.firstName = human.firstName;
            this.lastName = human.lastName;
            this.age = human.age;
            this.height = human.height;
            this.weight = human.weight;
            this.sex = human.sex;
        }

        public Human(String firstName, String lastName, boolean sex){
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
        }

        public Human(String firstName, String lastName, int age, int height, boolean sex){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.height = height;
            this.sex = sex;
        }
    }
}
