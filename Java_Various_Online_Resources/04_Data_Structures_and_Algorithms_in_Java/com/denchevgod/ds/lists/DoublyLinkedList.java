package com.denchevgod.ds.lists;

public class DoublyLinkedList<T> extends AbstractList<T> {

    private Node<T> head;

    private Node<T> tail;

    public DoublyLinkedList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.next = tail;
    }

    public T getFirst() {
        if (isEmpty())
            return null;
        return head.next.val;
    }

    public T getLast() {
        if (isEmpty())
            return null;
        return tail.prev.val;
    }

    public void addFirst(T val) {
        addBetween(val, head, head.next);
    }

    public void addLast(T val) {
        addBetween(val, tail.prev, tail);
    }

    public T removeFirst() {
        if (isEmpty())
            return null;
        return remove(head.next);
    }

    public T removeLast() {
        if (isEmpty())
            return null;
        return remove(tail.prev);
    }

    private void addBetween(T val, Node<T> pred, Node<T> suc) {
        Node<T> tmp = new Node<>(val, pred, suc);
        pred.next = tmp;
        suc.prev = tmp;
        size++;
    }

    private T remove(Node<T> tmp) {
        tmp.prev.next = tmp.next;
        tmp.next.prev = tmp.prev;
        size--;
        return tmp.val;
    }

    private static class Node<T> {
        private T val;
        private Node<T> next;
        private Node<T> prev;

        private Node(T val, Node<T> prev, Node<T> next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
