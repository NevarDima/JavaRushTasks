package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet(){
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max(16,(int)Math.ceil(collection.size()/.75f));
        this.map = new HashMap<>(capacity);
        addAll(collection);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean isAdd = false;
        for (E e: c) {
           if(add(e)){
               isAdd = true;
           }
        }
        return isAdd;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone() {
        AmigoSet clone;
        try{
            clone = (AmigoSet) super.clone();
            clone.map = (HashMap) map.clone();
        }catch (Exception e) {
            throw new InternalError();
        }
        return clone;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        oos.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        oos.writeInt(map.keySet().size());
        for (E e : map.keySet()) {
            oos.writeObject(e);
        }


    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        int capacity = ois.readInt();
        float loadFactor = ois.readFloat();
        map = new HashMap<>(capacity,loadFactor);
        int size = ois.readInt();
        for (int i = 0; i < size; i++) {
            map.put((E) ois.readObject(),PRESENT);
        }
    }

}

