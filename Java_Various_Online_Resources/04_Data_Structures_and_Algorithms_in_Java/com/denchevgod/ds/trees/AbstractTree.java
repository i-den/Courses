package com.denchevgod.ds.trees;

import java.util.Iterator;

public abstract class AbstractTree<T> implements Tree<T> {

    public boolean isInternal(TreeNode<T> treeNode) {
        return childCnt(treeNode) > 0;
    }

    @Override
    public boolean isExternal(TreeNode<T> treeNode) {
        return childCnt(treeNode) == 0;
    }

    @Override
    public boolean isRoot(TreeNode<T> treeNode) {
        return treeNode == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(TreeNode<T> treeNode) {
        if (isRoot(treeNode))
            return 0;
        return 1 + depth(parent(treeNode));
    }

    public int height(TreeNode<T> treeNode) {
        int h = 0;
        for (TreeNode<T> child : children(treeNode)) {
            h = Math.max(h, 1 + height(child));
        }
        return h;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
