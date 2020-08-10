package com.denchevgod.ds.trees;

public interface BinaryTree<T> extends Tree<T> {

    TreeNode<T> left(TreeNode<T> treeNode);

    TreeNode<T> right(TreeNode<T> treeNode);

    TreeNode<T> sibling (TreeNode<T> treeNode);
}
