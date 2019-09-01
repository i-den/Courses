package com.denchevgod.ds.lists;

import java.util.Arrays;

public class ArrayList<T> {

    private static final int DEFAULT_CAPACITY = 7;

    private Object[] elements;

    private int size;

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        elements = new Object[capacity];
    }

    public void add(T element) {
        if (size == elements.length) {
            grow();
        }
        elements[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index <= 0 || size <= index) {
            throw new IndexOutOfBoundsException("Index requested: "+index+" Size: "+size);
        }
        return (T) elements[index];
    }

    private void grow() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }
}
