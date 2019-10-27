package com.denchevgod.ds.trees;

abstract class AbstractTree<T> implements Tree<T> {

    public boolean isInternal(TreeNode<T> node) {
        return childCnt(node) > 0;
    }

    public boolean isExternal(TreeNode<T> node) {
        return childCnt(node) == 0;
    }

    public boolean isRoot(TreeNode<T> node) {
        return root() == node;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(TreeNode<T> node) {
        if (isRoot(node))
            return 0;
        return 1 + depth(node.parent);
    }

    public int height(TreeNode<T> node) {
        int h = 0;
        for (TreeNode<T> child : children(node)) {
            h = Math.max(h, 1 + height(node));
        }
        return h;
    }

    static class TreeNode<T> {
        T ele;
        TreeNode<T> parent;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T ele, TreeNode<T> parent, TreeNode<T> left, TreeNode<T> right) {
            this.ele = ele;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
}
