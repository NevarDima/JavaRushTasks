package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandDadName = reader.readLine();
        Cat catGrandDad = new Cat(grandDadName);

        String grandMomName = reader.readLine();
        Cat catGrandMom = new Cat(grandMomName);

        String dadName = reader.readLine();
        Cat catDad = new Cat(dadName, null, catGrandDad);

        String momName = reader.readLine();
        Cat catMom = new Cat(momName, catGrandMom, null);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMom, catDad);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMom, catDad);

        System.out.println(catGrandDad);
        System.out.println(catGrandMom);
        System.out.println(catDad);
        System.out.println(catMom);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private final String name;
        private Cat parent1;
        private Cat parent2;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parent1, Cat parent2) {
            this.name = name;
            this.parent1 = parent1;
            this.parent2 = parent2;
        }

        @Override
        public String toString() {
            if (parent1 != null ){
                if (parent2 != null){
                    return "The cat's name is " + name + ", mother is " + parent1.name + ", father is " + parent2.name;
                } else {
                    return "The cat's name is " + name + ", mother is " + parent1.name + ", no father";
                }
            } else {
                if (parent2 != null){
                    return "The cat's name is " + name + ", no mother, father is " + parent2.name;
                }
            }
            return "The cat's name is " + name + ", no mother, no father";
        }
    }
}
