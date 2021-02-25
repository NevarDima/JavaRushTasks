package com.javarush.task.task35.task3501;

public class GenericStatic<T extends Number> {
    public static <T> T someStaticMethod(T t) {
        System.out.println(t);
        return t;
    }
}
