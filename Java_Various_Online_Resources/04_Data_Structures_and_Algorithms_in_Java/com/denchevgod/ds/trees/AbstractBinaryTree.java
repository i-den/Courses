package com.denchevgod.ds.trees;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<T> extends AbstractTree<T>
                                            implements BinaryTree<T> {

    public TreeNode<T> sibling(TreeNode<T> node) {
        TreeNode<T> parent = parent(node);
        if (parent == null) {
            return null;
        }
        TreeNode<T> leftChild = left(parent);
        if (leftChild == null) {
            return right(parent);
        }
        return leftChild;
    }

    @Override
    public int childCnt(TreeNode<T> node) throws IllegalArgumentException {
        int cnt = 0;
        if (left(node) != null)
            cnt++;
        if (right(node) != null)
            cnt++;
        return cnt;
    }

    @Override
    public Iterable<TreeNode<T>> children(TreeNode<T> node) throws IllegalArgumentException {
        List<TreeNode<T>> children = new ArrayList<>(2);
        TreeNode<T> leftChild = left(node);
        TreeNode<T> rightChild = right(node);
        if (leftChild != null)
            children.add(leftChild);
        if (rightChild != null)
            children.add(rightChild);
        return children;
    }
}
