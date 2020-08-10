package com.denchevgod.ds.trees;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<T> extends AbstractTree<T> implements BinaryTree<T> {

    public TreeNode<T> sibling(TreeNode<T> treeNode) {
        TreeNode<T> parent = parent(treeNode);
        if (parent == null) {
            return null;
        }
        if (treeNode == left(parent)) {
            return right(parent);
        }
        return left(parent);
    }

    @Override
    public int childCnt(TreeNode<T> treeNode) {
        int cnt = 0;
        if (left(treeNode) != null)
            cnt++;
        if (right(treeNode) != null)
            cnt++;
        return cnt;
    }

    @Override
    public Iterable<TreeNode<T>> children(TreeNode<T> treeNode) {
        List<TreeNode<T>> children = new ArrayList<>(2);
        TreeNode<T> left = left(treeNode);
        TreeNode<T> right = right(treeNode);
        if (left != null)
            children.add(left);
        if (right != null)
            children.add(right);
        return children;
    }
}
