package com.javarush.task.task33.task3312;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Zoo.Cat.class, name="cat"),
        @JsonSubTypes.Type(value=Zoo.Dog.class, name="dog")
})
public class Zoo {
    public List<Animal> animals = new ArrayList<>();

    public static class Animal {
        public Animal(String name) {
            this.name = name;
        }

        public String name;
    }

    public static class Dog extends Animal {

        public double barkVolume;

        public Dog(String name) {
            super(name);
        }
    }

    public static class Cat extends Animal {
        boolean likesCream;
        public int lives;

        public Cat(String name) {
            super(name);
        }
    }
}