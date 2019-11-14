package com.denchevgod.ds.lists;

public class SinglyLinkedList<T> extends AbstractList<T> {

    private Node<T> head;

    private Node<T> tail;

    public SinglyLinkedList() {}

    @Override
    public T peekFirst() {
        if (isEmpty())
            return null;
        return head.val;
    }

    @Override
    public T peekLast() {
        if (isEmpty())
            return null;
        return tail.val;
    }

    @Override
    public void addFirst(T val) {
        head = new Node<>(val, head);
        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    @Override
    public void addLast(T val) {
        Node<T> tmp = new Node<>(val, null);
        if (isEmpty()) {
            head = tmp;
            tail = head;
        } else {
            tail.next = tmp;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty())
            return null;
        T val = head.val;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return val;
    }
}
