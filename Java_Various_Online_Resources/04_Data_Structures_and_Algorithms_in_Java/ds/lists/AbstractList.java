package com.denchevgod.ds.lists;

abstract class AbstractList<T> implements List<T> {
    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    static class Node<T> {
        T val;
        Node<T> next;

        Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }
    }
}