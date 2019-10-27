package com.denchevgod.ds.trees;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedBinaryTree<T> extends AbstractBinaryTree<T> {

    protected TreeNode<T> root = null;

    private int size = 0;

    public LinkedBinaryTree() {
    }

    protected TreeNode<T> validate(TreeNode<T> node) throws IllegalArgumentException {
        if (node.parent == node)
            throw new IllegalArgumentException("Node is no longer in the tree");
        return node;
    }

    public TreeNode<T> root() {
        return root;
    }

    public int size() {
        return size;
    }

    @Override
    public TreeNode<T> parent(TreeNode<T> node) {
        node = validate(node);
        return node.parent;
    }

    @Override
    public TreeNode<T> left(TreeNode<T> node) {
        node = validate(node);
        return node.left;
    }

    @Override
    public TreeNode<T> right(TreeNode<T> node) {
        node = validate(node);
        return node.right;
    }

    public TreeNode<T> addRoot(T ele) throws IllegalStateException {
        if (!isEmpty())
            throw new IllegalStateException("Tree is not empty");
        root = new TreeNode<>(ele, null, null, null);
        size = 1;
        return root;
    }

    public TreeNode<T> addLeft(TreeNode<T> node, T ele) {
        TreeNode<T> parent = parent(node);
        if (parent.left != null) {
            throw new IllegalArgumentException("Node already has left child");
        }
        TreeNode<T> child = new TreeNode<>(ele, parent, null, null);
        parent.left = child;
        size++;
        return child;
    }

    public TreeNode<T> addRight(TreeNode<T> node, T ele) {
        TreeNode<T> parent = parent(node);
        if (parent.right != null) {
            throw new IllegalArgumentException("Node already has right child");
        }
        TreeNode<T> child = new TreeNode<>(ele, parent, null, null);
        parent.right = child;
        size++;
        return child;
    }

    public T set(TreeNode<T> node, T ele) throws IllegalArgumentException {
        node = validate(node);
        T temp = node.ele;
        node.ele = ele;
        return temp;
    }

    public void attach(TreeNode<T> node, LinkedBinaryTree<T> firstTree, LinkedBinaryTree<T> secTree) throws IllegalArgumentException {
        node = validate(node);
        if (isInternal(node))
            throw new IllegalArgumentException("The node must be a leaf");
        size += firstTree.size + secTree.size;
        if (!firstTree.isEmpty()) {
            firstTree.root.parent = node;
            node.left = firstTree.root;
            firstTree.root = null;
            firstTree.size = 0;
        }
        if (!secTree.isEmpty()) {
            secTree.root.parent = node;
            node.right = secTree.root;
            secTree.root = null;
            secTree.size = 0;
        }
    }

    public T remove(TreeNode<T> node) throws IllegalArgumentException {
        node = validate(node);
        if (childCnt(node) == 2)
            throw new IllegalArgumentException("Node has two children");
        TreeNode<T> child = (node.left != null ? node.left : node.right);
        if (child != null)
            child.parent = node.parent;
        if (node == root) {
            root = child;
        } else {
            if (node == node.parent.left)
                node.parent.left = child;
            else
                node.parent.right = child;
        }
        size--;
        T temp = node.ele;
        node.ele = null;
        node.left = null;
        node.right = null;
        node.parent = node;
        return temp;
    }

    @Override
    public Iterator<T> iterator() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public Iterable<TreeNode<T>> positions() {
        throw new NotImplementedException(); // TODO
    }

    public Iterable<TreeNode<T>> preOrder() {
        List<TreeNode<T>> snapshot = new ArrayList<>();
        if (!isEmpty())
            preOrderSubtree(root, snapshot);
        return snapshot;
    }

    private void preOrderSubtree(TreeNode<T> node, List<TreeNode<T>> snapshot) {
        snapshot.add(node);
        for (TreeNode<T> child : children(node)) {
            preOrderSubtree(child, snapshot);
        }
    }

    public Iterable<TreeNode<T>> inOrder() {
        List<TreeNode<T>> snapshot = new ArrayList<>();
        if (!isEmpty())
            inOrderSubtree(root, snapshot);
        return snapshot;
    }

    private void inOrderSubtree(TreeNode<T> node, List<TreeNode<T>> snapshot) {
        if (left(node) != null)
            inOrderSubtree(left(node), snapshot);
        snapshot.add(node);
        if (right(node) != null)
            inOrderSubtree(right(node), snapshot);
    }

    public Iterable<TreeNode<T>> postOrder() {
        List<TreeNode<T>> snapshot = new ArrayList<>();
        if (!isEmpty())
            postOrderSubtree(root, snapshot);
        return snapshot;
    }

    private void postOrderSubtree(TreeNode<T> node, List<TreeNode<T>> snapshot) {
        for (TreeNode<T> child : children(node)) {
            postOrderSubtree(child, snapshot);
        }
        snapshot.add(node);
    }

    public Iterable<TreeNode<T>> breadthFirst() {
        List<TreeNode<T>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            ArrayDeque<TreeNode<T>> queue = new ArrayDeque<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                TreeNode<T> node = queue.pollFirst();
                snapshot.add(node);
                for (TreeNode<T> child : children(node)) {
                    queue.addLast(child);
                }
            }
        }
        return snapshot;
    }


}
