package com.denchevgod.ds.trees;

public class LinkedBinaryTree<T> extends AbstractBinaryTree<T> {

    private Node<T> root;

    private int size = 0;

    public LinkedBinaryTree() {}

    @Override
    public TreeNode<T> root() {
        return root;
    }

    @Override
    public TreeNode<T> left(TreeNode<T> treeNode) {
        return ((Node<T>) treeNode).left;
    }

    @Override
    public TreeNode<T> right(TreeNode<T> treeNode) {
        return ((Node<T>) treeNode).right;
    }

    @Override
    public TreeNode<T> parent(TreeNode<T> treeNode) {
        return ((Node<T>) treeNode).parent;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<TreeNode<T>> nodes() {
        return null;
    }

    public Node<T> addRoot(T val) throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException("Tree is not empty");
        root = new Node<>(val, null, null, null);
        size = 1;
        return root;
    }

    public Node<T> addLeft(Node<T> node, T val) {
        if (node.left != null)
            throw new IllegalArgumentException("The node already has a left child");
        node.left = new Node<>(val, node, null, null);
        size++;
        return node.left;
    }

    public Node<T> addRight(Node<T> node, T val) {
        if (node.right != null)
            throw new IllegalArgumentException("The node already has a left child");
        node.right = new Node<>(val, node, null, null);
        size++;
        return node.right;
    }

    public T remove(Node<T> node) throws IllegalArgumentException {
        if (childCnt(node) == 2)
            throw new IllegalArgumentException("The node has 2 children");
        Node<T> child = node.left == null ? node.right : node.left;
        if (node == root) {
            root = child;
        } else {
            if (node == node.parent.left) {
                node.parent.left = child;
            } else {
                node.parent.right = child;
            }
        }
        size--;
        return node.val;
    }

    static class Node<T> implements TreeNode<T> {
        private T val;
        private Node<T> parent;
        private Node<T> left;
        private Node<T> right;

        Node(T val, Node<T> parent, Node<T> left, Node<T> right) {
            this.val = val;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
}
