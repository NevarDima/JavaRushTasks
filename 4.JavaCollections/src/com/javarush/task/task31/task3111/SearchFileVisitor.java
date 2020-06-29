package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int maxSize;
    private int minSize;
    private List<Path> foundFiles = new ArrayList<>();


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] contentInByte = Files.readAllBytes(file); // размер файла: content.length

        boolean containsName = true;
        if(partOfName!=null && !file.getFileName().toString().contains(partOfName)) {
            containsName = false;
        }

        String content = new String(contentInByte);
        boolean containsContent = true;
        if(partOfContent!=null && !content.contains(partOfContent)) {
            containsContent = false;
        }

        boolean biggerMinSize = true;
        if(minSize!=0 && contentInByte.length<=minSize){
            biggerMinSize = false;
        }

        boolean smallerMaxSize = true;
        if(maxSize!=0 && contentInByte.length>=maxSize){
            smallerMaxSize = false;
        }

        if(containsName && containsContent && biggerMinSize && smallerMaxSize) {
            foundFiles.add(file);
        }

        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String partOfName){
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent){
        this.partOfContent = partOfContent;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
