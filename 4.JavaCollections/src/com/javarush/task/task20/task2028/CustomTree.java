package com.javarush.task.task20.task2028;

import sun.management.snmp.jvmmib.EnumJvmRTBootClassPathSupport;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;

    CustomTree(){
        this.root = new Entry<>("0");
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        int count = 0;
        ArrayDeque<Entry<String>> deque = new ArrayDeque<>();
        Entry<String> tempEntry = root;
        deque.add(tempEntry);

        do{
            if(!deque.isEmpty()){
                tempEntry = deque.poll();
            }
            if(tempEntry.leftChild != null){
                deque.add(tempEntry.leftChild);
                count++;
            }
            if(tempEntry.rightChild != null){
                deque.add(tempEntry.rightChild);
                count++;
            }
        }while (!deque.isEmpty());
        return count;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    public String getParent(String elementName){
        Entry<String> tempEntry = findEntry(elementName);
        if(tempEntry == null){
            return null;
        }
        return tempEntry.parent.elementName;
    }

    public boolean add(String element) {
        ArrayDeque<Entry<String>> deque = new ArrayDeque<>();
        Entry<String> tempEntry = root;
        deque.add(tempEntry);
        do{
            if(!deque.isEmpty()){
                tempEntry = deque.poll();
            }
            if(!tempEntry.availableToAddLeftChildren && !tempEntry.availableToAddRightChildren &&
            tempEntry.leftChild == null && tempEntry.rightChild == null){
                tempEntry.availableToAddLeftChildren = true;
                tempEntry.availableToAddRightChildren = true;
            }
            if(tempEntry.leftChild != null){
                deque.add(tempEntry.leftChild);
            }else if(tempEntry.availableToAddLeftChildren){
                tempEntry.leftChild = new Entry<>(element);
                tempEntry.leftChild.parent = tempEntry;
                return true;
            }
            if(tempEntry.rightChild != null){
                deque.add(tempEntry.rightChild);
            }else if(tempEntry.availableToAddRightChildren){
                tempEntry.rightChild = new Entry<>(element);
                tempEntry.rightChild.parent = tempEntry;
                return true;
            }
        }while (!deque.isEmpty());
        return false;

    }

    public boolean remove(Object o){
        String elementName;
        try{
            elementName = (String) o;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
        Entry<String> tempEntry = findEntry(elementName);
        if(tempEntry.equals(tempEntry.parent.leftChild)){
            tempEntry.parent.leftChild = null;
            tempEntry.parent.availableToAddLeftChildren = false;
            return true;
        }
        if(tempEntry.equals(tempEntry.parent.rightChild)){
            tempEntry.parent.rightChild = null;
            tempEntry.parent.availableToAddRightChildren = false;
            return true;
        }
        return false;
    }

    public Entry<String> findEntry(String elementName){
        ArrayDeque<Entry<String>> deque = new ArrayDeque<>();
        Entry<String> tempEntry = root;
        deque.add(tempEntry);

        do{
            if(!deque.isEmpty()){
                tempEntry = deque.poll();
            }
            if(tempEntry.elementName.equals(elementName)){
                return tempEntry;
            }
            if(tempEntry.leftChild != null){
                deque.add(tempEntry.leftChild);
            }
            if(tempEntry.rightChild != null){
                deque.add(tempEntry.rightChild);
            }
        }while (!deque.isEmpty());
        return null;
    }

    static class Entry<T> implements Serializable{
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName){
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
