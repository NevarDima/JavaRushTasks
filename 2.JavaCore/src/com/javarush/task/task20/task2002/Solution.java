package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            for (int i = 0; i <=10 ; i++) {
                User user;
                if(i == 0) {
                    user = new User();
                }else {
                    user = new User();
                    user.setFirstName("fn" + i);
                    user.setLastName("ln" + i);
                    user.setBirthDate(new Date(100000000000L+100000000000L*i));
                    user.setMale((new Random()).nextBoolean());
                    user.setCountry(User.Country.OTHER);
                }
                javaRush.users.add(user);
            }

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if(javaRush.equals(loadedObject)){
                System.out.println("javaRush object is equal to the loadedObject object");
            }else{
                System.out.println("javaRush object is NOT equal to the loadedObject object");
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            String isUsersPresent = !users.isEmpty()?"yes":"no";
            printWriter.println(isUsersPresent);
            printWriter.flush();

            if(isUsersPresent.equals("yes")){
                for (User user : users) {
                    printWriter.println(user.getFirstName());
                    printWriter.println(user.getLastName());
                    if(user.getBirthDate()!=null) {
                        printWriter.println(user.getBirthDate().getTime());
                    }else{
                        printWriter.println("null");
                    }
                    printWriter.println(user.isMale());
                    if(user.getCountry()!=null) {
                        printWriter.println(user.getCountry().getDisplayName());
                    }else{
                        printWriter.println("null");
                    }
                }
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            if(br.readLine().equals("yes")){
                while(br.ready()){
                    User user = new User();
                    String firstName = br.readLine();
                    if(!firstName.equals("null")) {
                        user.setFirstName(firstName);
                    }
                    String lastName = br.readLine();
                    if(!lastName.equals("null")) {
                        user.setLastName(lastName);
                    }
                    String birthDate = br.readLine();
                    if(!birthDate.equals("null")) {
                        user.setBirthDate(new Date(Long.parseLong(birthDate)));
                    }
                    user.setMale(br.readLine().equals("true"));
                    String country = br.readLine();
                    if(country.equals("Ukraine")) user.setCountry(User.Country.UKRAINE);
                    if(country.equals("Russia")) user.setCountry(User.Country.RUSSIA);
                    if(country.equals("Other")) user.setCountry(User.Country.OTHER);
                    users.add(user);
                }
            }
            br.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
