package com.javarush.task.task14.task1419;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            FileReader fileReader = new FileReader("");

        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }

        try {
            Object o = new Object();
            Solution solution = (Solution)o;

        } catch (ClassCastException e) {
            exceptions.add(e);
        }

        try {
            int i = Integer.parseInt("a");

        } catch (NumberFormatException e) {
            exceptions.add(e);
        }

        try {
            int i = Integer.getInteger("a");

        } catch (NullPointerException e) {
            exceptions.add(e);
        }

        try {
            int[] i = new int[2];
            for (int i1 = 0; i1 <= i.length; i1++) {
                i[i1] = 1;
            }

        } catch (IndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            IllegalArgumentException iae = new IllegalArgumentException();
            throw iae;

        } catch (IllegalArgumentException e) {
            exceptions.add(e);
        }

        try {
            RuntimeException re = new RuntimeException();
            throw re;

        } catch (RuntimeException e) {
            exceptions.add(e);
        }

        try {
            ClassNotFoundException cnfe = new ClassNotFoundException();
            throw cnfe;

        } catch (ClassNotFoundException e) {
            exceptions.add(e);
        }

        try {
            SQLException sqle = new SQLException();
            throw sqle;

        } catch (SQLException e) {
            exceptions.add(e);
        }
    }
}
