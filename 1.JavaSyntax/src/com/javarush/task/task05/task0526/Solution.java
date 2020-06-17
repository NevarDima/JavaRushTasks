package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man man1 = new Man("Dima",32,"Kalinovskogo");
        Man man2 = new Man("Andrey",37,"Amsterdam");

        Woman woman1 = new Woman("Tanya",27,"Kalinovskogo");
        Woman woman2 = new Woman("Lena",27,"Amsterdam");

        System.out.println(man1.toString());
        System.out.println(man2.toString());

        System.out.println(woman1.toString());
        System.out.println(woman2.toString());
    }

    //напишите тут ваш код

    public static class Man{
        String name;
        int age;
        String address;

        public Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Man(String name, int age){
            this.name = name;
            this.age = age;
        }

        public Man(String name){
            this.name = name;
        }

        public String toString(){
            return (name + " " + age + " " + address);
        }

    }

    public static class Woman{
        String name;
        int age;
        String address;

        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Woman(String name, int age){
            this.name = name;
            this.age = age;
        }

        public Woman(String name){
            this.name = name;
        }

        public String toString(){
            return (name + " " + age + " " + address);
        }
    }
}
