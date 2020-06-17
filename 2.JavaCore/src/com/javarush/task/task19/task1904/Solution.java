package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String[] strPerson = new String[4];
            Date personDate = null;
            if(fileScanner.hasNextLine()){
                strPerson = fileScanner.nextLine().split(" ",4);
                SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
                personDate = sdf.parse(strPerson[3]);
            }
            return new Person(strPerson[1],strPerson[2],strPerson[0],personDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
