package com.denchevgod.ds.lists;

public class CircularlyLinkedList<T> extends AbstractList<T> {

    private Node<T> tail;

    public CircularlyLinkedList() {
    }

    public T first() {
        if (isEmpty())
            return null;
        return tail.next.val;
    }

    public T last() {
        if (isEmpty())
            return null;
        return tail.val;
    }

    public void rotate() {
        if (tail != null)
            tail = tail.next;
    }

    public void addFirst(T val) {
        if (isEmpty()) {
            tail = new Node<>(null, val);
            tail.next = tail;
        } else {
            tail.next = new Node<>(tail.next, val);
            ;
        }
        size++;
    }

    public void addLast(T val) {
        addFirst(val);
        tail = tail.next;
    }

    public T removeFirst() {
        if (isEmpty())
            return null;
        Node<T> head = tail.next;
        if (tail == head) {
            tail = null;
        } else {
            tail.next = head.next;
        }
        size--;
        return head.val;
    }

    private static class Node<T> {
        private Node<T> next;
        private T val;

        private Node(Node<T> next, T val) {
            this.next = next;
            this.val = val;
        }
    }
}
