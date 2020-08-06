package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    static List<String> passList = new ArrayList<>();

    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        final char[] lowerCase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        final char[] upperCase = "ABCDEFGJKLMNPRSTUVWXYZ".toCharArray();
        final char[] digits = "0123456789".toCharArray();
        final char[] allCaseAndDigits = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789".toCharArray();

        Random random = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            stringBuilder.append(allCaseAndDigits[random.nextInt(allCaseAndDigits.length)]);
        }
        stringBuilder.append(lowerCase[random.nextInt(lowerCase.length)]);
        stringBuilder.append(upperCase[random.nextInt(upperCase.length)]);
        stringBuilder.append(digits[random.nextInt(digits.length)]);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        if(passList.contains(stringBuilder.toString())){
            return getPassword();
        }else{
            try {
                byteArrayOutputStream.write(stringBuilder.toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return byteArrayOutputStream;
    }
}