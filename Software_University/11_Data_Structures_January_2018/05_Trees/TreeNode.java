package com.denchevgod;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeNode<T> {

    private T value;

    private TreeNode<T> parent;

    private List<TreeNode<T>> children = new ArrayList<>();

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode(T value, TreeNode<T>... treeNodes) {
        this.value = value;
        for (TreeNode<T> treeNode : treeNodes) {
            treeNode.setParent(this);
        }
        Collections.addAll(children, treeNodes);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public boolean isRoot() {
        return parent == null;
    }

    public void printDepthFirst() {
        for (TreeNode<T> child : children) {
            child.printDepthFirst();
        }
        System.out.println(value);
    }

    public void printBreadthFirst() {
        // TODO
    }

    private void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public void addChild(TreeNode<T> treeNode) {
        children.add(treeNode);
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }
}
