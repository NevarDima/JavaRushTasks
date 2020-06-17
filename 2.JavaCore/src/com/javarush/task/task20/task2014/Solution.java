package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        System.out.println(new Solution(4));

        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            InputStream inputStream = new FileInputStream(your_file_name);
            ObjectInputStream ois = new ObjectInputStream(inputStream);

            Solution solution1 = new Solution(27);
            oos.writeObject(solution1);
            outputStream.close();
            oos.close();

            Object object = ois.readObject();
            inputStream.close();
            ois.close();
            Solution someSolution = (Solution) object;
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

            System.out.println(solution1.string.equals(someSolution.string));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
