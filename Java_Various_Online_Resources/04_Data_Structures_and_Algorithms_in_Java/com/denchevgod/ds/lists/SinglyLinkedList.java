package com.denchevgod.ds.lists;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> extends AbstractList<T> {

    private Node<T> head = null;

    private Node<T> tail = null;

    public SinglyLinkedList() {}

    public void addFirst(T ele) {
        Node<T> tmp = new Node<>(ele);
        tmp.next = head;
        head = tmp;
        if (isEmpty()) {
            head = tail;
        }
        size++;
    }

    public void addLast(T ele) {
        Node<T> tmp = new Node<>(ele);
        if (isEmpty()) {
            head = tmp;
        } else {
            tail.next = tmp;
        }
        tail = tmp;
        size++;
    }

    public T getFirst() {
        if (isEmpty())
            throw new NoSuchElementException("List is empty");
        Node<T> tmp = head;
        head = tmp.next;
        size--;
        return tmp.ele;
    }

    public T getLast() {
        if (isEmpty())
            throw new NoSuchElementException("List is empty");
        Node<T> tmp = tail;
        Node<T> pen = penultimateNode();
        pen.next = null;
        tail = pen;
        size--;
        return tmp.ele;
    }

    private Node<T> penultimateNode() {
        if (size == 1)
            return head;
        Node<T> tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp;
    }

    private static class Node<T> {
        T ele;
        Node<T> next;
        Node(T ele) {
            this.ele = ele;
        }
    }
}
