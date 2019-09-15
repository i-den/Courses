package com.denchevgod.ds.trees;

import java.util.Collection;

public class BinaryTree<T extends Comparable<T>> {

    Node<T> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Collection<T> values) {
        for (T value : values) {
            add(value);
        }
    }

    public void add(T value) {
        root = addRecursive(root, value);
    }

    private Node<T> addRecursive(Node<T> node, T value) {
        if (node == null)
            return new Node<>(value);

        if (node.value.equals(value))
            return node;

        int valCmp = node.value.compareTo(value);
        if (valCmp > 0) {
            node.left = addRecursive(node.left, value);
        } else {
            node.right = addRecursive(node.right, value);
        }

        return node;
    }

    private Node<T> deleteRecursive(Node<T> node, T value) {
        if (node == null)
            return null;

        if (node.value.equals(value)) {
            if (node.left == null && node.right == null)
                return null;

            if (node.right == null)
                return node.left;

            if (node.left == null)
                return node.right;

            Node<T> smallestNode = findSmallestValue(root);
            node.value = smallestNode.value;
            node.right = deleteRecursive(node.right, node.value);
            return node;
        }

        int nodeCmp = node.value.compareTo(value);
        if (nodeCmp > 0) {
            node.left = deleteRecursive(node.left, value);
        } else {
            node.right = deleteRecursive(node.right, value);
        }
        return node;
    }

    private Node<T> findSmallestValue(Node<T> node) {
        return node.left == null ? node : findSmallestValue(node.left);
    }

    public boolean contains (T value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node<T> node, T value) {
        if (node == null)
            return false;
        if (node.value.equals(value))
            return true;

        int nodeCmp = node.value.compareTo(value);
        if (nodeCmp > 0) {
            return containsRecursive(node.left, value);
        } else {
            return containsRecursive(node.right, value);
        }
    }

    private static class Node<T extends Comparable<T>> {
        T value;
        Node<T> left;
        Node<T> right;

        Node(T value) {
            this.value = value;
        }
    }
}
