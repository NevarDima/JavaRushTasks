package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        int ageScore = Integer.compare(this.age, anotherCat.age);
        int weightScore = Integer.compare(this.weight, anotherCat.weight);
        int strengthScore = Integer.compare(this.strength, anotherCat.strength);
        int res = ageScore+weightScore+strengthScore;
        if(res>0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

        Cat cat1 = new Cat();
        cat1.age = 10;
        cat1.weight = 7;
        cat1.strength = 50;

        Cat cat2 = new Cat();
        cat2.age = 7;
        cat2.weight = 5;
        cat2.strength = 70;

        System.out.println(cat1.fight(cat2));
        System.out.println(cat2.fight(cat1));


    }
}
