package com.denchevgod.ds.trees;

import com.denchevgod.ds.trees.AbstractTree.TreeNode;

public interface BinaryTree<T> extends Tree<T> {

    TreeNode<T> left(TreeNode<T> node) throws IllegalArgumentException;

    TreeNode<T> right(TreeNode<T> node) throws IllegalArgumentException;

    TreeNode<T> sibling(TreeNode<T> node) throws IllegalArgumentException;
}
