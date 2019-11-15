package com.denchevgod.ds.lists;

public class DoublyLinkedList<T> extends AbstractList<T> {

    private Node<T> head;

    private Node<T> tail;

    public DoublyLinkedList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.next = tail;
    }

    @Override
    public T peekFirst() {
        return head.next.val;
    }

    @Override
    public T peekLast() {
        return tail.prev.val;
    }

    @Override
    public void addFirst(T val) {
        addBetween(val, head, head.next);
    }

    @Override
    public void addLast(T val) {
        addBetween(val, tail.prev, tail);
    }

    private void addBetween(T val, Node<T> before, Node<T> after) {
        Node<T> tmp = new Node<>(val, before, after);
        before.next = tmp;
        after.prev = tmp;
        size++;
    }

    @Override
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

    private T remove(Node<T> tmp) {
        tmp.prev.next = tmp.next;
        tmp.next.prev = tmp.prev;
        size--;
        return tmp.val;
    }

    private static class Node<T> {
        private T val;
        private Node<T> prev;
        private Node<T> next;

        private Node(T val, Node<T> prev, Node<T> next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
