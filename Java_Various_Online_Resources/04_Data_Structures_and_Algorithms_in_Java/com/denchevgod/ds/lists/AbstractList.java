package com.denchevgod.ds.lists;

abstract class AbstractList<T> {
    int size = 0;

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    
}
