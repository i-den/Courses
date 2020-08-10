package com.denchevgod.ds.lists;

public interface List<T> {
    int size();

    boolean isEmpty();

    T peekFirst();

    T peekLast();

    void addFirst(T val);

    void addLast(T val);

    T removeFirst();
}
