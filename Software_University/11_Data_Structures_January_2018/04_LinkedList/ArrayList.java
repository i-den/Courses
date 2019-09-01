package com.denchevgod.ds.lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

    private Node head;

    private Node tail;

    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(T element) {
        Node node = new Node(element);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addLast(T element) {
        Node node = new Node(element);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node oldHead = head;
        head = head.next;
        size--;
        return oldHead.value;
    }

    public T removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }

        if (size == 1) {
            T val = tail.value;
            head = null;
            tail = null;
            size--;
            return val;
        }

        Node node = head;
        while (node.next != tail) {
            node = node.next;
        }
        T val = node.next.value;
        tail = node;
        size--;
        return val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                Node temp = node;
                node = node.next;
                return temp.value;
            }
        };
    }

    public int getSize() {
        return this.size;
    }

    private class Node {
        T value;

        Node next;

        Node(T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }
    }
}
