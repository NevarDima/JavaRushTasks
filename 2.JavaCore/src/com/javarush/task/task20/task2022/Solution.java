package com.javarush.task.task20.task2022;

import java.io.*;

/*
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\r\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution solution1 = new Solution("/Users/Dima/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2022/file.txt");

        solution1.writeObject("записываем данные");

        String saveFileName = "/Users/Dima/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2022/save.bin";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFileName));

        oos.writeObject(solution1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/Dima/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2022/save.bin"));

        Solution solution2 = (Solution) ois.readObject();
        solution2.writeObject("записываем данные из востановленного объекта");
        ois.close();
    }
}
